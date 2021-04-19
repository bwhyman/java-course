package com.example25.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {

    public static void main(String[] args) {
        // getBox();

        GenericsTest.<Animal>getArrayList();

    }

    private static void getBox() {
        Box<Integer> box = new Box<>(10);
        int num = box.getT();
        System.out.println(num);
        Box<String> box2 = new Box<>("BO");
        System.out.println(box2.getT());
    }


	private static void te() {
		List<? extends Animal> list = null;
		List<Animal> animals = null;
		List<Bird> birds = null;
		list = animals;
		list = birds;

	}

    private static <E> List<E> getArrayList() {
        List<E> list = new ArrayList<>();
        return list;
    }
}
