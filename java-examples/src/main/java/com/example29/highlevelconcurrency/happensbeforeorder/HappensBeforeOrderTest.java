package com.example29.highlevelconcurrency.happensbeforeorder;

public class HappensBeforeOrderTest {



    public static void main(String[] args) throws InterruptedException {
        // loopTest();
        // loopTest2();
        loopTest3();
    }

    private static void loopTest() throws InterruptedException {
        new Thread(HappensBeforeOrderTest::loop).start();
        Thread.sleep(500);
        stop = true;
    }

    private static void loopTest2() throws InterruptedException {
        new Thread(HappensBeforeOrderTest::loop2).start();
        Thread.sleep(500);
        stop2 = true;
    }
    private static void loopTest3() throws InterruptedException {
        Thread.ofPlatform().start(HappensBeforeOrderTest::loop3);
        Thread.sleep(500);
        stop3 = true;
    }

    // 无法停止。子线程复制变量stop到本地，并一直基于本地变量副本操作
    // 主线程对变量的修改，不会影响子线程
    private static boolean stop = false;
    private static void loop() {
        while (!stop) {
        }
        System.out.println("loop end");
    }

    // 可以停止。子线程栈没有保存变量stop的本地副本，每次循环均从主内存读取数据
    // 因此主线程修改变量后会影响子线程
    private static volatile boolean stop2 = false;
    private static void loop2() {
        while (!stop2) {
        }
        System.out.println("loop end");
    }

    // 可以停止。虽然没有使用volatile，但System.out.println()是同步方法
    // 其锁定了System内部的out输出流对象，同一时间只能有一个线程使用输出流对象
    // 确保多线程输出时，不会在输出中途插入其他线程输出数据
    // 基于jvm Happens-before Order规范
    // 释放锁同步数据时，与锁有关的其他修改也将同步(x happens-before y)，以确保同步操作的可见性
    // 所以主线程对变量的修改，再某次println()释放锁同步时也被同步
    // 因此即使没有使用volatile，也更新了子线程栈上的变量
    // https://docs.oracle.com/javase/specs/jls/se8/html/jls-17.html#jls-17.4.5
    private static boolean stop3 = false;
    private static void loop3() {
        while (!stop3) {
            System.out.println("");
        }
        System.out.println("loop end");
    }
}
