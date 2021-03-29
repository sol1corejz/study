package com.company;

/**
 * Homework 5
 * @version 1
 * @author Parunov Ilya
 */

public class Main {

    public volatile static int sum = 0;

    /**
     * Пример входной строки.
     */
    public static final String INPUT_STRING = "Невежество есть мать промышленности, как и суеверий." +
            " Сила размышления и воображения подвержена ошибкам; но привычка двигать рукой или ногой" +
            " не зависит ни от того, ни от другого. Поэтому мануфактуры лучше всего процветают там, где" +
            " наиболее подавлена духовная жизнь, так что мастерская может рассматриваться как машина," +
            " части которой составляют люди.";

    /**
     * Шаблон поиска символов в строке.
     */
    public static final String TEMPLATE = " ";

    /**
     * Точка входа в приложение.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) throws InterruptedException {
        MatchThreads[] matchers = new MatchThreads[20];

        for (int i = 0; i < matchers.length; i++){
            matchers[i] = new MatchThreads();
        }

        long current = System.currentTimeMillis();
        for (MatchThreads x: matchers){
            x.start();
        }
        for (MatchThreads x: matchers){
            //flag  чтобы отслдеживать выполнение и замерить время
            while (!x.flag){}
        }

        System.out.println("Time: " + (System.currentTimeMillis() - current) / 1000 + " c.");
        System.out.println("Count of space: " + sum);
    }
}
