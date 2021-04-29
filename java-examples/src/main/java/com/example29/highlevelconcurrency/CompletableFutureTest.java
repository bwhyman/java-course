package com.example29.highlevelconcurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // test1();
        // test2();
        // test3();
        // allOftest();
    }

    private static void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> c = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.println(Thread.currentThread().getName());
            return 5;
        });
        // get()阻塞方法
        System.out.println(Thread.currentThread().getName());
        System.out.println(c.get());
    }

    private static void test2() {
        CompletableFuture<Integer> c = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.println(Thread.currentThread().getName());
            return 5;
        });
        CompletableFuture.allOf(c).join();
        System.out.println("df");
    }

    private static void test3() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> c = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.println(Thread.currentThread().getName());
            return 5;
        }).thenApply(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.println(Thread.currentThread().getName());
            return x + 1;
        }).thenApplyAsync(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.out.println(Thread.currentThread().getName());
            return x + 1;
        });
        // 等待异步的c执行完毕
        CompletableFuture.allOf(c);
        System.out.println(c.get());
    }

    private static void test4() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> c = CompletableFuture.supplyAsync(() -> 5)
                .thenApply(x -> x + 1)
                .thenApplyAsync(x -> x + 1);
        // 等待异步的c执行完毕
        CompletableFuture.allOf(c);
        System.out.println(c.get());
    }

    private static void allOftest() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<Integer> c = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            return 5;
        });
        CompletableFuture<Integer> c1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            return 5;
        });
        CompletableFuture<Integer> c2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            return 5;
        });
        // join()，执行此方法的线程等待
        CompletableFuture.allOf(c, c1, c2).join();
        long end = System.currentTimeMillis();
        System.out.println(c.get() + c.get() + c2.get());
        System.out.println(end - start);
    }
}
