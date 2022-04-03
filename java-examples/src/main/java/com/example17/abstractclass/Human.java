package com.example17.abstractclass;

public class Human extends Organism{
    public Human(String name) {
        super(name);
    }
    @Override
    public void move() {
        System.out.println(getName() +
                " move as human.");
    }
}
