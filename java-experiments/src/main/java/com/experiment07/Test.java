package com.experiment07;

import com.experiment07.entity.TrainOutlet;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        test();
    }

    private static void test() throws InterruptedException {
        TrainOutlet t1 = new TrainOutlet();
        TrainOutlet t2 = new TrainOutlet();
        TrainOutlet t3 = new TrainOutlet();

        new Thread(() -> {
            while (t1.sell() != null) {

            }
        }).start();
        new Thread(() -> {
            while (t2.sell() != null) {

            }
        }).start();
        new Thread(() -> {
            while (t3.sell() != null) {

            }
        }).start();

        Thread.sleep(5000);

        System.out.println(t1.getCount());
        System.out.println(t2.getCount());
        System.out.println(t3.getCount());
    }
}
