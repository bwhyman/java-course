package com.example08.constructor;

public class Student {
    private int nefuNumber;
    private String name;
    private boolean lazy;

    public Student(int nefuNumber, String name, boolean lazy) {
        this.nefuNumber = nefuNumber;
        this.name = name;
        this.lazy = lazy;
    }

    public int getNefuNumber() {
        return nefuNumber;
    }

    public void setNefuNumber(int nefuNumber) {
        this.nefuNumber = nefuNumber;
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
