package com.example.music;

public interface MusicGenre extends MusicItem {
    String getType();  // переопределим getName() как getType()

    @Override
    default String getName() {
        return getType();
    }
}
