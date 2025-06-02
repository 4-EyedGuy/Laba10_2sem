package com.example.music;

public class Artist implements MusicItem {
    private String name;
    private String genre;

    public Artist() {}

    public Artist(String name, String genre) {
        this.name = name;
        this.genre = genre;
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
