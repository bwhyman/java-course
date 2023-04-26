package com.example28.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        // getHelloRunnable();
        // getHelloThread();
        // getThreadSleep();
        // getInterrupt();
        // getJoin();
        // getThreadInterference();
        // getThreadInterferenceSync();
        // getThreadInterference2();
        // getThreadInterference3();
        // getVolatile();
    }

    private static void getHelloRunnable() {
        Thread t = new Thread(new HelloRunnable());
        t.start();
    }

    private static void getHelloThread() {
        new HelloThread().start();
    }

    private static void getThreadSleep() {
        System.out.println("main thread running");
        new Thread(new Runnable() {
            @Override
            public void run() {
                int amount = 5;
                for (int i = 0; i < amount; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }).start();
        System.out.println("main thread ending");
    }

    //
    private static void getThreadSleep2() {
        System.out.println("main thread running");
        new Thread(new Runnable() {
            @Override
            public void run() {
                int amount = 5;
                for (int i = 0; i < amount; i++) {
                    System.out.println(i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        }).start();
        System.out.println("main thread ending");
    }

    private static void getInterrupt() throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                    System.out.println("Interrupted");
                    return;
                }
            }
        });
        t.start();
        // 主线程sleep，确保子线程已经开始执行
        Thread.sleep(2000);
        // 中断子线程
        t.interrupt();
    }

    private static void getJoin() throws InterruptedException {
        System.out.println("main thread running");
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
        });
        t.start();
        t.join();
        System.out.println("main thread ending");
    }
    // 未使用同步，累加结果错误
    private static void getThreadInterference() throws InterruptedException {
        Counter counter = new Counter();
        int count = 800;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                counter.increment();
                latch.countDown();
            }).start();
        }
        // 主线程执行到方此法将阻塞，直至锁计数器为零
        latch.await();
        System.out.println("执行结课：" + counter.getC());
    }
    private static void getThreadInterferenceSync() throws InterruptedException {
        Counter counter = new Counter();
        int count = 800;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                counter.incrementSync();
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println("执行结课：" + counter.getC());
    }

    private static void getThreadInterference2() throws InterruptedException {
        int count = 800;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                Counter2.increment();
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println("执行结课：" + Counter2.value());
    }

    private static void getThreadInterference3() throws InterruptedException {
        int count = 800;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                Counter3.increment();
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println("执行结课：" + Counter3.value());
    }

    private static void getVolatile() throws InterruptedException {
        int count = 8_000;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                VolatileCount.increment();
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println("执行结课：" + VolatileCount.value());
    }
}
