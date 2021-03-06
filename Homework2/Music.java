package com.company;

import java.util.Objects;

public class Music {

    private String artist;
    private String name;

    Music(String artist, String name){
        this.artist = artist;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Music music = (Music) o;
        return Objects.equals(artist, music.artist) && Objects.equals(name, music.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, name);
    }

    @Override
    public String toString() {
        return "" +
                "" + artist  +
                " - " + name;
    }
}
