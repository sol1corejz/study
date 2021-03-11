package com.company;

public class MultimediaPlayer extends AudioDevice{

    public void play(RecordingDevice device){
        if (device instanceof Multimedia){
            for (Music i : device.getSongs()){
                System.out.println("Playing: " + i.toString() + " On MultimediaPlayer");
            }
        }
        else{
            System.out.println("Songs cannot be played on this device!");
        }
    }

}
