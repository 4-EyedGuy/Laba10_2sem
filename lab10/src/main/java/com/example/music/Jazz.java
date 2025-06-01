package com.example.music;

import org.springframework.stereotype.Component;

@Component("jazz")
public class Jazz implements MusicGenre {
    @Override
    public String getType() {
        return "Jazz";
    }
}