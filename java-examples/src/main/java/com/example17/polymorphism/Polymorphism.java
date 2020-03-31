package com.example17.polymorphism;

public class Polymorphism {

    public static void main(String[] args) {
        System.out.println("-------Inheritance --------");
        //getBrid();
        System.out.println("-------Overrde Inheritance --------");
        //getOverrde();
        System.out.println("-------instanceof --------");
        //getinstanceof();
        System.out.println("-------Casting Objects--------");
        //getCastingObjects();
        System.out.println("-------Polymorphism--------");
        //getPolymorphism();
        System.out.println("-------Polymorphism by interface--------");
        //getPolymorphismByInterface();
        System.out.println("-------Polymorphism final--------");
        //getPolymorphism2();
        System.out.println("-------Hiding Static Methods--------");
        //getHidingStaticMethod();

    }

    private static void getBrid() {
        Bird bird = new Bird("Raven", "black");
        bird.move();
        bird.fly();
        System.out.println(bird.getName() + "/" +bird.getColor());

    }

    private static void getOverrde() {
        Bird bird = new Bird("Raven", "black");
        bird.move();
        Animal animal = new Animal("Lion");
        animal.move();
    }

    private static void getinstanceof() {
        Bird bird = new Bird("Raven", "black");
        System.out.println(bird instanceof Bird);
        System.out.println(bird instanceof Animal);
        System.out.println(bird instanceof Object);
    }

    private static void getCastingObjects() {
        Bird bird = new Bird("Raven", "black");
        System.out.println(bird.getClass().getName());
        Animal animal = bird;
        ((Bird) animal).fly();
        System.out.println(animal.getClass().getName());
        Object obj = bird;
        System.out.println(obj.getClass().getName());

        Animal animal2 = new Animal("Lion");
        System.out.println(animal2.getClass().getName());
        // 异常
        //Bird bird2 = (Bird) animal2;
    }

    private static void getPolymorphism() {
        Animal animal = new Animal("Lion");
        animal.move();
        Bird bird = new Bird("Raven", "black");
        bird.move();
        Animal animal2 = bird;
        animal2.move();
    }

    private static void getPolymorphismByInterface() {
        Movable animal = new Animal("Lion");
        System.out.println(animal.getClass().getName());
        Flyable bird = new Bird("Raven", "black");
        bird.fly();
    }
    private static void getPolymorphism2() {
        Bird bird = new Bird("Raven", "black");
        System.out.println(bird.getClass().getName());
        bird.fly();bird.move();
        System.out.println(bird.getColor());
        // 表现Animal行为
        Animal animal = bird;
        animal.move();
        System.out.println(animal.getName());
        // 表现Movable能力
        Movable mBird = bird;
        mBird.move();
        // 表现Flyable能力
        Flyable fBird = bird;
        fBird.fly();
    }

    private static void getHidingStaticMethod() {
        Animal.barking();
        Bird.barking();
    }

}
