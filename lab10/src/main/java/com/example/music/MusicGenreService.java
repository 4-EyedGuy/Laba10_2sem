package com.example.music;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MusicGenreService {

    private final List<MusicGenre> genres = new ArrayList<>();

    public MusicGenreService() {
        genres.add(new SimpleGenre("Rock"));
        genres.add(new SimpleGenre("Jazz"));
    }

    public List<MusicGenre> getAllGenres() {
        return new ArrayList<>(genres);
    }

    public MusicGenre getGenreByName(String name) {
        return genres.stream()
                .filter(g -> g.getType().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void addGenre(MusicGenre genre) {
        genres.add(genre);
    }

    public void updateGenre(String originalName, MusicGenre updatedGenre) {
        for (int i = 0; i < genres.size(); i++) {
            if (genres.get(i).getType().equalsIgnoreCase(originalName)) {
                genres.set(i, updatedGenre);
                return;
            }
        }
    }

    public void removeGenreByName(String name) {
        genres.removeIf(g -> g.getType().equalsIgnoreCase(name));
    }

    public void addArtistToGenre(String genreName, Artist artist) {
        MusicGenre genre = getGenreByName(genreName);
        if (genre instanceof SimpleGenre) {
            ((SimpleGenre) genre).addArtist(artist);
        }
    }

    public void removeArtistFromGenre(String genreName, String artistName) {
        MusicGenre genre = getGenreByName(genreName);
        if (genre instanceof SimpleGenre) {
            ((SimpleGenre) genre).removeArtistByName(artistName);
        }
    }

}
