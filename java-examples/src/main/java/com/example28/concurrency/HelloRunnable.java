package com.example28.concurrency;

public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from HelloRunnable!");
    }
}
