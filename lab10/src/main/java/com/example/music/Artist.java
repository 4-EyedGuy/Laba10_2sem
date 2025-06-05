package com.example.music;

import java.util.List;
import java.util.ArrayList;
import com.example.music.Artist;
import com.example.music.MusicGenre;

public class Artist implements MusicItem {
    private String name;
    private String genre;

    public Artist() {}

    public Artist(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
