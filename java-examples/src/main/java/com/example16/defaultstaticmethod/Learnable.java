package com.example16.defaultstaticmethod;

public interface Learnable {

    void read(String bookName);
    int test(String courseName);
    default void study() {
        System.out.println("study");
    }

    int STUDY_TIME = 8;
    static int getLeftTime(int hours) {
        return hours - STUDY_TIME;
    }
}

