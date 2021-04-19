package com.example28.concurrency;

import java.util.Random;

public class VolatileCount {
    private static volatile int c;
    private static Random r = new Random();
    public static void increment() {
        try {
            // 模拟随机的耗时业务操作
            Thread.sleep(r.nextInt(50));
            c++;
        } catch (InterruptedException ignored) {
        }
    }
    public static int value() {
        return c;
    }
}
