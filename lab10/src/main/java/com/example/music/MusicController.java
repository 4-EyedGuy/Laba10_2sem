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
    @Autowired
    private MusicGenreService musicGenreService;

    @GetMapping("/genres")
    public String showAllGenres(Model model) {
        model.addAttribute("genres", genreService.getAllGenres());
        model.addAttribute("newGenre", new GenreForm());
        return "genres";
    }

    @PostMapping("/add-genre")
    public String addGenre(@ModelAttribute("newGenre") GenreForm form) {
        if (form.getType() != null && !form.getType().trim().isEmpty()) {
            genreService.addGenre(new SimpleGenre(form.getType()));
        }
        return "redirect:/genres";
    }

    @GetMapping("/genre")
    public String getGenre(@RequestParam("name") String name, Model model) {
        SimpleGenre genre = (SimpleGenre) musicGenreService.getGenreByName(name);
        if (genre == null) {
            return "redirect:/genres";
        }
        model.addAttribute("genre", genre);

        GenreForm genreForm = new GenreForm();
        genreForm.setOldType(name);
        model.addAttribute("genreForm", genreForm);

        return "genre";
    }

    @GetMapping("/edit-genre")
    public String showEditGenreForm(@RequestParam String name, Model model) {
        GenreForm form = new GenreForm();
        form.setOldType(name);
        form.setType(name);
        model.addAttribute("genreForm", form);
        return "edit-genre";
    }

    @PatchMapping("/edit-genre")
    public String editGenre(@ModelAttribute("genreForm") GenreForm form) {
        MusicGenre updatedGenre = new SimpleGenre(form.getType());
        genreService.updateGenre(form.getOldType(), updatedGenre);
        return "redirect:/genres";
    }

    @DeleteMapping("/delete-genre")
    public String deleteGenre(@RequestParam String name) {
        musicGenreService.removeGenreByName(name);
        return "redirect:/genres";
    }

    @PostMapping("/add-artist")
    public String addArtist(@RequestParam("genre") String genreName, @RequestParam("artistName") String artistName) {
        Artist artist = new Artist(artistName);
        musicGenreService.addArtistToGenre(genreName, artist);
        return "redirect:/genre?name=" + genreName;
    }

    @DeleteMapping("/delete-artist")
    public String deleteArtist(@RequestParam String genre, @RequestParam String artistName) {
        musicGenreService.removeArtistFromGenre(genre, artistName);
        return "redirect:/genre?name=" + genre;
    }


    public static class GenreForm {
        private String oldType;
        private String type;

        public String getOldType() { return oldType; }
        public void setOldType(String oldType) { this.oldType = oldType; }

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
    }
}