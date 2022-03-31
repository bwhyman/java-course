package com.example17.polymorphism;

public class Bird extends Animal implements Flyable {

    private String color;
    public Bird(String name, String color) {
        super(name);
        this.color = color;
        Animal.barking();
    }
    @Override
    public void fly() {
        System.out.println(getName() + " is flying");
    }
    @Override
    public void move() {
        System.out.println(getName() + " move so slow");
    }
    @Override
    public long getCount() {
        return 0;
    }
    @Override
    protected Bird getMovable() {
        return null;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public static void barking() {
        System.out.println("Bird barking");
    }
}
