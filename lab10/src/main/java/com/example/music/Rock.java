package com.example.music;

import org.springframework.stereotype.Component;

@Component("rock")
public class Rock implements MusicGenre {
    private String type = "Rock";

    @Override
    public String getType() {
        return type;
    }
}
