package com.example25.initialorder;

public class C {
    private A a = null;

    public C(A a) {
        this.a = a;
    }

    public C() {
        System.out.println("C: constructor");
    }
    static {
        System.out.println("C: static block");
    }
}
