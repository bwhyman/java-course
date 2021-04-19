package com.example28.concurrency;

public class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from HelloThread!");
    }
}
