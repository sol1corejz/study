package com.company;

/**
 * Homework 2 CROC
 * @version 1
 * @author Parunov Ilya
 */

public class Main {

    public static void main(String[] args) {

        Music song1 = new Music("John Lennon","Imagine");
        Music song2 = new Music("Nirvana","Smells Like Teen Spirit");
        Music song3 = new Music("Metallica","Enter Sandman");

        AudioDevice songR1 = new VinylTurntable(song1, "VinylTurntable");
        AudioDevice songR2 = new SD(song2, "SD");
        AudioDevice songR3 = new SD(song3, "SD");

        songR1.playOn("VinylTurntable");
        songR1.playOn("SD");
        songR2.playOn("SD");
        songR3.playOn("SD");
        songR3.playOn("aye");
    }
}
