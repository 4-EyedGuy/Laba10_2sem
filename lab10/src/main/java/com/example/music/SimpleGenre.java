package com.example.music;

import java.util.List;
import java.util.ArrayList;
import com.example.music.Artist;
import com.example.music.MusicGenre;

public class SimpleGenre implements MusicGenre {

    private String type;
    private List<Artist> artists = new ArrayList<>();


    public SimpleGenre() {}

    public SimpleGenre(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void addArtist(Artist artist) {
        artists.add(artist);
    }

    public void removeArtistByName(String name) {
        artists.removeIf(a -> a.getName().equalsIgnoreCase(name));
    }
}
