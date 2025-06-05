package com.example.music;

public interface MusicGenre extends MusicItem {
    String getType();

    @Override
    default String getName() {
        return getType();
    }
}
