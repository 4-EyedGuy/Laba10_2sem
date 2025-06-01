package com.example.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MusicController {

    @Autowired
    private MusicGenreService genreService;

    @GetMapping("/genres")
    public String showAllGenres(Model model) {
        model.addAttribute("genres", genreService.getAllGenres());
        return "genres";
    }

    @GetMapping("/genre")
    public String showGenre(Model model, @RequestParam String name) {
        MusicGenre genre = genreService.getGenreByName(name);
        model.addAttribute("genre", genre);
        return "genre";
    }

    @GetMapping("/add-genre")
    public String showAddGenreForm(Model model) {
        model.addAttribute("newGenre", new MusicGenreForm());
        return "add-genre";
    }

    @PostMapping("/add-genre")
    public String addGenreSubmit(@ModelAttribute MusicGenreForm newGenre) {
        MusicGenre genre = new CustomGenre(newGenre.getType());
        genreService.addGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("/edit-genre")
    public String showEditGenreForm(@RequestParam String name, Model model) {
        GenreForm form = new GenreForm();
        form.setOldType(name);
        form.setType(name);
        model.addAttribute("genre", form);
        return "edit-genre";
    }

    @PatchMapping("/edit-genre")
    public String editGenre(@ModelAttribute GenreForm form) {
        genreService.updateGenre(form.getOldType(), new SimpleGenre(form.getType()));
        return "redirect:/genres";
    }

    @DeleteMapping("/delete-genre")
    public String deleteGenre(@RequestParam String name) {
        genreService.removeGenreByName(name);
        return "redirect:/genres";
    }

    public static class MusicGenreForm {
        private String type;

        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
    }

    public static class CustomGenre implements MusicGenre {
        private final String type;

        public CustomGenre(String type) {
            this.type = type;
        }

        @Override
        public String getType() {
            return type;
        }
    }
}

