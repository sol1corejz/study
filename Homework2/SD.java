package com.company;

public class SD extends AudioDevice{


    SD(Music song, String type) {
        super(song, type);
    }

    public void playOn(String type) {
        if (this.type.equals(type)){
            System.out.println("Playing: " + this.song.toString() + " On " + this.type);
        }
        else {
            System.out.println("Song cannot be played on this device!");
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
