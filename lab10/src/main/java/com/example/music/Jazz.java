package com.example.music;

import org.springframework.stereotype.Component;

@Component("jazz")
public class Jazz implements MusicGenre {
    private String type = "Jazz";

    @Override
    public String getType() {
        return type;
    }
}