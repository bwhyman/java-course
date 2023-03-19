package com.example29.highlevelconcurrency.lock;

import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        LockTest();
    }
    private static void LockTest() throws InterruptedException {
        int count = 8_000;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                Counter.increment();
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println(Counter.value());
    }
}
