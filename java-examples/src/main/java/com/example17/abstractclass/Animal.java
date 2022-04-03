package com.example17.abstractclass;

public class Animal extends Organism{
    public Animal(String name) {
        super(name);
    }
    @Override
    public void move() {
        System.out.println(getName() +
                " move in many ways.");
    }
}
