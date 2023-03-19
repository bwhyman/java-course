package com.example29.highlevelconcurrency.localthread;

public class Test {
    public static void main(String[] args) throws Exception {
        localThreadTest();
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
