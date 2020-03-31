package com.example15.interfaces;

public class Postgraduate implements Learnable {
    private String name;
    public Postgraduate(String name) {
        this.name = name;
    }
    @Override
    public void read(String bookName) {
        System.out.println("以研究生方式读：" + bookName);
    }
    @Override
    public int test(String courseName) {
        System.out.println("以研究生方式考试：" + courseName);
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
