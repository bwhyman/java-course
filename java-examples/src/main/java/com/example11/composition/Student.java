package com.example11.composition;

public class Student {
    private int number;
    private String name;
    private boolean lazy;

    public Student(int number, String name, boolean lazy) {
        this.number = number;
        this.name = name;
        this.lazy = lazy;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLazy() {
        return lazy;
    }

    public void setLazy(boolean lazy) {
        this.lazy = lazy;
    }

}
