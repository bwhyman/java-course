package com.example28.concurrency;

import java.util.Random;

public class Counter {
    private Random r = new Random();
    private int c;
    public void increment() {
        try {
            // 模拟随机的耗时业务操作
            Thread.sleep(r.nextInt(50));
            c++;
        } catch (InterruptedException ignored) {
        }
    }
    public synchronized void incrementSync() {
        try {
            // 模拟随机的耗时业务操作
            Thread.sleep(r.nextInt(50));
            c++;
        } catch (InterruptedException ignored) {
        }
    }
    public int getC() {
        return c;
    }
}
