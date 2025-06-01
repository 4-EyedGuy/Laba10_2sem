package com.example.music;

public class SimpleGenre implements MusicGenre {
    private String type;

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
}
