package com.company;

import java.util.Objects;

public class AudioDevice {

    protected String type = "";
    protected Music song;

    AudioDevice(Music song, String type){
        this.type = type;
        this.song = song;
    }
     void playOn(String type){};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AudioDevice that = (AudioDevice) o;
        return Objects.equals(type, that.type) && Objects.equals(song, that.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, song);
    }

    @Override
    public String toString() {
        return "AudioDevice{" +
                "type='" + type + '\'' +
                ", song=" + song +
                '}';
    }
}
