package com.example.music;

import org.springframework.stereotype.Component;

@Component("rock")
public class Rock implements MusicGenre {
    @Override
    public String getType() {
        return "Rock";
    }
}
