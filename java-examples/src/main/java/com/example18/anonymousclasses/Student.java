package com.example18.anonymousclasses;

public class Student {
    private String name;
    private Learnable learnable;
    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Learnable getLearnable() {
        return learnable;
    }
    public void setLearnable(Learnable learnable) {
        this.learnable = learnable;
    }

}
