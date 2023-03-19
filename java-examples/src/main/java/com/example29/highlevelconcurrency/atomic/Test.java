package com.example29.highlevelconcurrency.atomic;

import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main(String[] args) throws Exception {
        AtomicIntegerTest();
    }

    private static void AtomicIntegerTest() throws InterruptedException {
        int count = 8_000;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                Counter2.increment();
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println(Counter2.value());
    }
}
