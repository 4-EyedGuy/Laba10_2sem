package com.example.music;

import com.example.music.Artist;
import com.example.music.MusicGenre;
import com.example.music.MusicItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MusicDisplay {

    private final List<MusicGenre> genres = new ArrayList<>();
    private final List<Artist> artists = new ArrayList<>();

    public MusicDisplay() {
        genres.add(new Rock());
        genres.add(new Jazz());

        artists.add(new Artist("Linkin Park", "Rock"));
        artists.add(new Artist("Frank Sinatra", "Jazz"));
    }

    public List<MusicGenre> getGenres() {
        return genres;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void addGenre(MusicGenre genre) {
        boolean exists = genres.stream()
                .anyMatch(g -> g.getType().equalsIgnoreCase(genre.getType()));
        if (!exists) {
            genres.add(genre);
        }
    }

    public void updateGenre(String oldName, String newName) {
        genres.stream()
                .filter(g -> g.getType().equalsIgnoreCase(oldName))
                .findFirst()
                .ifPresent(g -> {
                    if (g instanceof SimpleGenre) {
                        ((SimpleGenre) g).setType(newName);
                    }
                    else {
                        genres.remove(g);
                        genres.add(new SimpleGenre(newName));
                    }
                });
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public MusicGenre getGenreByName(String name) {
        return genres.stream()
                .filter(g -> g.getType().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Artist getArtistByName(String name) {
        return artists.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void removeGenreByName(String name) {
        genres.removeIf(g -> g.getType().equalsIgnoreCase(name));
    }

    public boolean removeArtistByName(String name) {
        return artists.removeIf(a -> a.getName().equals(name));
    }

    public List<MusicItem> getAllItems() {
        List<MusicItem> items = new ArrayList<>();
        items.addAll(genres);
        items.addAll(artists);
        return items;
    }
}
