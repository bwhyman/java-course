package com.example28.concurrency;

import java.util.Random;

public class Counter3 {
    private static Random r = new Random();
    private static Account account = new Account();
    public static void increment() {
        try {
            Thread.sleep(r.nextInt(50));
            synchronized (account) {
                account.setC(account.getC() + 1);
            }
        } catch (InterruptedException ignored) {
        }
    }
    public static int value() {
        return account.getC();
    }

}
