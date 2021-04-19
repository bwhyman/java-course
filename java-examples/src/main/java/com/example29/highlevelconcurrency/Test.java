package com.example29.highlevelconcurrency;

import java.time.LocalTime;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws Exception {
        // LockTest();
        // executorTest();
        // executorTest1();
        // AtomicIntegerTest();
        //localThreadTest();
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
    private static void executorTest() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() +
                            "/" + LocalTime.now());
                } catch (InterruptedException ignored) {
                }
            });
        }
        // 等待executor中任务全部完成后关闭
        service.shutdown();
    }
    private static void executorTest1() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() +
                            "/" + LocalTime.now());
                } catch (InterruptedException ignored) {
                    System.out.println("被中断");
                }
            });
        }
        Thread.sleep(1000);
        // 中断executor中任务的执行后关闭
        service.shutdownNow();
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

    private static void localThreadTest() {
        Runnable r = () -> {
            for (int j = 0; j < 1000; j++) {
                Counter3.increment();
            }
            System.out.println(Counter3.value());
        };
        for (int i = 0; i < 3; i++) {
            new Thread(r).start();
        }
    }
}
