package com.company;

public class VinylPlayer extends AudioDevice{

    public void play(RecordingDevice device){
        if (device instanceof VinylTurntable){
            for (Music i : device.getSongs()){
                System.out.println("Playing: " + i.toString() + " On VinylTurntable");
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
