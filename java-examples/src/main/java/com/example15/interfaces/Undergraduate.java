package com.example15.interfaces;

public class Undergraduate implements Learnable, Playable{
    private String name;
    public Undergraduate(String name) {
        this.name = name;
    }
    @Override
    public void read(String bookName) {
        System.out.println("以本科生方式读：" + bookName);
    }
    @Override
    public int test(String courseName) {
        System.out.println("以本科生方式考试：" + courseName);
        return 0;
    }
    @Override
    public void sing(String songName) {
        // 实现基于指定歌名唱歌
        System.out.println("以本科生方式唱歌：" + songName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
