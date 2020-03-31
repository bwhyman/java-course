package com.example16.defaultstaticmethod;

public interface J9Interface {
    int NUM = 100;
    int a();
    default void b() {
        System.out.println("default");
    }
    private void c() {
        System.out.println("private");
    }
    static void d() {
        System.out.println("static");
    }
    private static void e() {
        System.out.println("private static");
    }
}
