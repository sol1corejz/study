package com.company;

import java.util.Objects;

abstract public class AudioDevice {

    protected String type = "";
    protected Music song;

    AudioDevice(Music song, String type){
        this.type = type;
        this.song = song;
    }
     abstract void playOn(String type);

}
