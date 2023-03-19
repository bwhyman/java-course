package com.example29.highlevelconcurrency.atomic;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter2 {
    private static final Random r = new Random();
    private static AtomicInteger c = new AtomicInteger(0);
    public static void increment() {
        try {
            Thread.sleep(r.nextInt(50));
            c.incrementAndGet();
        } catch (InterruptedException e) {
        }

    }
    public static int value() {
        return c.get();
    }
}
