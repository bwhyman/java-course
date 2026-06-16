package com.example28.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        // getHelloRunnable();
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
        Thread.ofPlatform()
                .start(new HelloRunnable());
    }

    private static void getThreadSleep() {
        IO.println("main thread running");
        Thread.ofPlatform()
                .start(() -> {
                    int amount = 5;
                    for (int i = 0; i < amount; i++) {
                        IO.println(i);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException ignored) {
                        }
                    }
                });
        IO.println("main thread ending");
    }

    private static void getInterrupt() throws InterruptedException {
        var t = Thread.ofPlatform()
                .start(() -> {
                    for (int i = 0; i < 5; i++) {
                        IO.println(i);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException ignored) {
                            IO.println("Interrupted");
                            return;
                        }
                    }
                });
        // 主线程sleep，确保子线程已经开始执行
        TimeUnit.SECONDS.sleep(2);
        // 中断子线程
        t.interrupt();
    }

    private static void getJoin() throws InterruptedException {
        IO.println("main thread running");
        var t = Thread.ofPlatform()
                .start(() -> {
                    for (int i = 0; i < 5; i++) {
                        IO.println(i);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException ignored) {
                        }
                    }
                });
        t.join();
        IO.println("main thread ending");
    }

    // 未使用同步，累加结果错误
    private static void getThreadInterference() throws InterruptedException {
        Counter counter = new Counter();
        int count = 800;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            Thread.ofPlatform()
                    .start(() -> {
                        counter.increment();
                        latch.countDown();
                    });
        }
        // 主线程执行到方此法将阻塞，直至锁计数器为零
        latch.await();
        IO.println("执行结课：" + counter.getC());
    }

    private static void getThreadInterferenceSync() throws InterruptedException {
        Counter counter = new Counter();
        int count = 800;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            Thread.ofPlatform()
                    .start(() -> {
                        counter.incrementSync();
                        latch.countDown();
                    });
        }
        latch.await();
        IO.println("执行结课：" + counter.getC());
    }

    private static void getThreadInterference2() throws InterruptedException {
        int count = 800;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            Thread.ofPlatform()
                    .start(() -> {
                        Counter2.increment();
                        latch.countDown();
                    });
        }
        latch.await();
        IO.println("执行结课：" + Counter2.value());
    }

    private static void getThreadInterference3() throws InterruptedException {
        int count = 800;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            Thread.ofPlatform()
                    .start(() -> {
                        Counter3.increment();
                        latch.countDown();
                    });
        }
        latch.await();
        IO.println("执行结课：" + Counter3.value());
    }

    private static void getVolatile() throws InterruptedException {
        int count = 8_000;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            Thread.ofPlatform()
                    .start(() -> {
                        VolatileCount.increment();
                        latch.countDown();
                    });
        }
        latch.await();
        IO.println("执行结课：" + VolatileCount.value());
    }

}
