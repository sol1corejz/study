package com.company;

public class MatchThreads extends Thread {
    public volatile static int globalPos = 0;
    public int localPos = 0;
    public static final Object lock = new Object();
    public boolean flag = false;

    @Override
    public void run() {
        while (globalPos < Main.INPUT_STRING.length()) {
            synchronized (lock){
                if (globalPos >= Main.INPUT_STRING.length()){
                    break;
                }
                localPos = globalPos;
                globalPos++;
            }
            if (Matcher.match(String.valueOf(Main.INPUT_STRING.charAt(localPos)), Main.TEMPLATE)) {
                Main.sum++;
            }
        }
        flag = true;
    }
}
