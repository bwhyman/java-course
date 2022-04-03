package com.example17.abstractclass;

public class Test {
    public static void main(String[] args) {
        Human bo = new Human("BO");
        Organism sun = new Human("SUN");
        sun.move();
        sun.sleep();
        Organism lion = new Animal("Lion");
        lion.move();
        lion.sleep();

        Organism org = new Organism("Alien") {
            @Override
            public void move() {
                System.out.println(getName() +
                        " maybe able to fly...");
            }
        };
    }
}
