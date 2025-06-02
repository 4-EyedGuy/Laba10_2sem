package com.example.music;

import com.example.music.MusicDisplay;
import com.example.music.Artist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArtistController {

    private final MusicDisplay musicDisplay;

    public ArtistController(MusicDisplay musicDisplay) {
        this.musicDisplay = musicDisplay;
    }

    @GetMapping("/artists")
    public String getArtists(Model model) {
        model.addAttribute("artists", musicDisplay.getArtists());
        model.addAttribute("newArtist", new Artist());
        return "artists";
    }

    @PostMapping("/add-artist")
    public String addArtist(@ModelAttribute Artist artist) {
        musicDisplay.addArtist(artist);
        return "redirect:/artists";
    }

    @GetMapping("/artist")
    public String viewArtist(@RequestParam String name, Model model) {
        Artist artist = musicDisplay.getArtistByName(name);
        model.addAttribute("artist", artist);
        return "artist";
    }

    @PostMapping(value = "/delete-artist", params = "_method=delete")
    public String deleteArtist(@RequestParam String name) {
        musicDisplay.removeArtistByName(name);
        return "redirect:/artists";
    }
}
