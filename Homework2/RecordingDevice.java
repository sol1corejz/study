package com.company;
import java.util.*;

abstract public class RecordingDevice {
    protected ArrayList<Music> songs;

    RecordingDevice(Music ... songs){
        this();
        this.songs.addAll(Arrays.asList(songs));
    }

    RecordingDevice(){
        this.songs = new ArrayList<>();
    }

    ArrayList<Music> getSongs(){
        return  songs;
    }

}
