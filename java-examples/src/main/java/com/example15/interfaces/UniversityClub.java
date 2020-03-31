package com.example15.interfaces;

public class UniversityClub {
    private String name;
    private Learnable learnable;

    public UniversityClub(String name) {
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
