package com.example12.nestedclass;

public class NestedClassTest {
    public static void main(String[] args) {
        testNestedClass();

    }

    private static void testNestedClass() {
        Person.IQ iq = new Person.IQ(250);
        Person person = new Person("BO", iq);
        System.out.println(person.getIq().getPoint());
    }
}
