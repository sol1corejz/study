package com.company;

public class SDPlayer extends RecordingDevice{

    SDPlayer(){}

    public void play(RecordingDevice device){
        if (device instanceof SDCard){
            for (Music i : device.getSongs()){
                System.out.println("Playing: " + i.toString() + " On SDCard");
            }
        }
        else{
            System.out.println("Songs cannot be played on this device!");
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
