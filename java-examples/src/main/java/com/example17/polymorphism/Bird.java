package com.example17.polymorphism;

public class Bird extends Animal implements Flyable {
    private String color;
    public Bird(String name, String color) {
        super(name);
        this.color = color;
    }
    @Override
    public void fly() {
        System.out.println(getName() + " is flying");
    }
    @Override
    public void move() {
        System.out.println(getName() + " move so slow");
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public static void barking() {
        System.out.println("Brid barking");
    }

}
