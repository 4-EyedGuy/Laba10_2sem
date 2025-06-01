package com.example.music;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicDisplay {

    private List<MusicGenre> genres = new ArrayList<>();

    @Autowired
    public MusicDisplay(List<MusicGenre> genres) {
        this.genres = genres;
    }

    public List<MusicGenre> getAllGenres() {
        return genres;
    }

    public MusicGenre getGenreByName(String name) {
        return genres.stream()
                .filter(g -> g.getType().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<MusicGenre> getGenres() {
        return genres;
    }

    public void addGenre(MusicGenre genre) {
        genres.add(genre);
    }

    public void updateGenre(String oldType, MusicGenre newGenre) {
        for (int i = 0; i < genres.size(); i++) {
            if (genres.get(i).getType().equalsIgnoreCase(oldType)) {
                genres.set(i, newGenre);
                break;
            }
        }
    }

    public void deleteGenreByName(String name) {
        genres.removeIf(g -> g.getType().equalsIgnoreCase(name));
    }


}
