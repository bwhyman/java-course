package com.example29.highlevelconcurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private static int c = 0;
    private static final Random r = new Random();
    private static final Lock lock = new ReentrantLock();
    public static void increment() {
        try {
            Thread.sleep(r.nextInt(50));
            lock.lock();
            c++;
        } catch (InterruptedException ignored) {
        } finally {
            lock.unlock();
        }
    }
    public static int value() {
        return c;
    }
}

