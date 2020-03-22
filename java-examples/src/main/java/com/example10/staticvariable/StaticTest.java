package com.example10.staticvariable;

public class StaticTest {
    public static void main(String[] args) {
        // testStaticVariable();
        testStaticBlock();
    }
    private static void testStaticBlock() {
        StaticBlock staticBlock = new StaticBlock();
    }

    static {
        System.out.println("StaticTest static");
    }

    private static void testStaticVariable() {
        Bicycle bicycle = new Bicycle();
        System.out.println(Bicycle.getAmount());
    }
    private static void testStaticStudent() {
        Student student = new Student("BO", Student.MALE);
        Student student1 = new Student("SUN", Student.FEMALE);
        Student student2 = new Student("ZHANG", Student.FEMALE);
    }


}
