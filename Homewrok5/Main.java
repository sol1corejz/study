package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger sum = new AtomicInteger(0);

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
    public static void main(String[] args) throws Exception{

        long current = System.currentTimeMillis();

        ExecutorService es = Executors.newFixedThreadPool(20);
        List<Future> tasks = new ArrayList<>();

        for (int i = 0; i < INPUT_STRING.length(); i++) {
            int pos = i;
            tasks.add(es.submit(() -> {
                if (Matcher.match(String.valueOf(INPUT_STRING.charAt(pos)), TEMPLATE)) {
                    sum.getAndIncrement();
                }
            }));
        }

        for (Future f : tasks){
            f.get();
        }
        es.shutdown();

        System.out.println("Count of space: " + sum);
        System.out.println("Time: " + (System.currentTimeMillis() - current) / 1000 + " c.");
    }
}