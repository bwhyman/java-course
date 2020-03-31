package com.example16.defaultstaticmethod;

public class Undergraduate implements Learnable, Playable{
    @Override
    public void read(String bookName) {
    }
    @Override
    public int test(String courseName) {
        return 0;
    }
    @Override
    public void sing(String songName) {
        System.out.println("Performance: " + songName);
    }

}
