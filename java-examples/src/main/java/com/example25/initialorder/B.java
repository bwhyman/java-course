package com.example25.initialorder;

public class B extends A {
	public B() {
				System.out.println("B: Constructor");
	}
	static {
		System.out.println("B: static block");
	}
	public static void getB() {
		System.out.println("B: static method getB()");
	}
}
