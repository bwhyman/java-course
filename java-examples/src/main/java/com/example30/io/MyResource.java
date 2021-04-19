package com.example30.io;

public class MyResource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Closed");
    }
}
