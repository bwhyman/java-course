package com.example29.highlevelconcurrency.executor;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws Exception {
        // executorTest();
        // executorTest1();
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
}
