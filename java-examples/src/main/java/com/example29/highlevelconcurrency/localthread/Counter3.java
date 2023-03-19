package com.example29.highlevelconcurrency.localthread;

import java.util.Random;

public class Counter3 {
    private static final Random r = new Random();
    private static final ThreadLocal<Integer> c = new ThreadLocal<>();
    public static void increment() {
        try {
            Thread.sleep(r.nextInt(50));
            // 为第一次赋值
            if (c.get() == null) {
                c.set(0);
            }
            c.set(c.get() + 1);
        } catch (InterruptedException ignored) {
        }
    }
    public static int value() {
        return c.get();
    }

}
