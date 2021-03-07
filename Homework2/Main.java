package com.company;

/**
 * Homework 2 CROC
 * @version 1
 * @author Parunov Ilya
 */

public class Main {

    public static void main(String[] args) {


        //Создаем 3 объекта типа Music(3 песни)
        Music song1 = new Music("John Lennon","Imagine");
        Music song2 = new Music("Nirvana","Smells Like Teen Spirit");
        Music song3 = new Music("Metallica","Enter Sandman");

        //Создаем 3 устройства на которых хранятся наши песни
        RecordingDevice SDSongs = new SDCard(song1, song3);
        RecordingDevice VinSongs = new VinylTurntable(song3);
        RecordingDevice MltMdSongs = new Multimedia(song1, song2, song3);

        //Создаем 4 пелейлиста и сразу проигрываем их(Результат выводится в консоль)
        SDPlayer playList1 = new SDPlayer();
        playList1.play(SDSongs);

        VinylPlayer playList2 = new VinylPlayer();
        playList2.play(VinSongs);

        VinylPlayer playList3 = new VinylPlayer();
        playList3.play(SDSongs);

        MultimediaPlayer playList4 = new MultimediaPlayer();
        playList4.play(MltMdSongs);
    }
}
