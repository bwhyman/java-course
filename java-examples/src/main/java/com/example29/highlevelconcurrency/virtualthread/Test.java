package com.example29.highlevelconcurrency.virtualthread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //createVT();
        //createVT2();
        // createPlatformThread();
        //createVTExecutor();
    }
    private static final int AMOUNT = 10_000;
    private static final CountDownLatch LATCH = new CountDownLatch(AMOUNT);
    private static final Runnable RUNNABLE = () -> {
        try {
            var thread = Thread.currentThread();
            System.out.println(thread + ": t1");
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(thread + ": t2");
            LATCH.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };

    private static void createVT() throws InterruptedException {
        // 直接执行任务
        Thread.startVirtualThread(RUNNABLE);

        // 直接创建并执行任务
        Thread.ofVirtual()
                .name("my-virtual-thread")
                .start(RUNNABLE);
        // 确保子线程执行完关闭主线程
        TimeUnit.SECONDS.sleep(1);
    }

    private static void createVT2() throws InterruptedException {
        for (int i = 0; i < AMOUNT; i++) {
            Thread.startVirtualThread(RUNNABLE);
        }
        LATCH.await();
    }

    private static void createPlatformThread() throws InterruptedException {
        for (int i = 0; i < AMOUNT; i++) {
            Thread.ofPlatform().start(RUNNABLE);
        }
        LATCH.await();
    }

    private static void createVTExecutor() {
        try (ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < AMOUNT; i++) {
                myExecutor.execute(RUNNABLE);
            }
        }
    }
}
