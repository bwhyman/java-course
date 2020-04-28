package com.example25.initialorder;

public class A {
    static {
        System.out.println("A: static block");
    }
    public A() {
        System.out.println("A: constructor");
    }

    private static String S = create();
        private static String create() {
            System.out.println("A: static method create()");
            return "";
    }

    public static String getS() {
        System.out.println("A: static method getS()");
        return S;
    }
    static {
        System.out.println("A: static block 2");
    }

}
