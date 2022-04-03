package com.example17.abstractclass;

public abstract class Organism {
    private String name;
    public Organism(String name) {
        this.name = name;
    }
    public void sleep() {
        System.out.println(name + " is sleeping");
    }
    public abstract void move();

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
