package com.example03.variable;

import com.example02.clazz.Bicycle;

public class VariableTest {
    public static void main(String[] args) {
        // 整数类型
        // getIntegerLiterals();
        System.out.println("------------");
        // 浮点类型
        // getFloatLiterals();
        System.out.println("------------");
        // 支持下划线分隔
        // getUnderscoreNumericLiterals();
        System.out.println("------------");
        // getCharacterandStringLiterals();
        System.out.println("------------");
        //getConstants();
        System.out.println("------------");
        getArrays();
    }

    /**
     * int整数类型，基本字面量
     */
    private static void getIntegerLiterals() {
        // 长整型
        long creditCardNumber = 1234567890123456L;
        System.out.println(creditCardNumber);
    }
    /**
     * float浮点类型，基本字面量
     */
    private static void getFloatLiterals() {
        double d1 = 123.4;
        // 基于科学计数法
        double d2 = 1.234e2;
        float f1 = 123.4F;
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(f1);
    }
    /**
     * 使用下划线分隔符的字面量
     */
    private static void getUnderscoreNumericLiterals() {
        long creditCardNumber = 1234_5678_9012_3456L;
        int ubNumber = 2014_2_1_4159;
        float pi = 3.14_15F;
        System.out.println(creditCardNumber);
        System.out.println(ubNumber);
        System.out.println(pi);
    }
    /**
     * 声明字符/字符串字面量，转义符
     */
    private static void getCharacterandStringLiterals() {
        char ch = '\u0058';
        char ch2 = 'X';
        System.out.println(ch);
        System.out.println(ch2);
        String s = "this is a string";
        System.out.println(s);
        String s2 = "\"It's freezing in here\", he said coldly.";
        System.out.println(s2);
        String s3 = "src\\com\\example";
        System.out.println(s3);

        String s4 = s + "sfs  df" + s2;
        System.out.println(s4);
    }

    /**
     *
     */
    private static void getBoolean() {
        boolean moving = false;
        boolean shopping  = true;
        if (moving) {
            System.out.println("Moving");
        }
    }

    /**
     * 声明常量
     */
    private static void getConstants() {
        final int NUM_GEARS = 6;
        System.out.println(NUM_GEARS);
        // 允许，先声明后赋值
        final String PROPERTY_FILE;
        PROPERTY_FILE = "application.properties";
    }
    /**
     * 声明数组
     */
    private static void getArrays() {
        // 声明创建一个可以包含3个元素的int类型数组
        int[] intArray = new int[10];
        // 先创建数组，后添加元素
        intArray[0] = 10; intArray[1] = 20;
        intArray[2] = 30; intArray[3] = 40;
        intArray[8] = 90;
        int index = 8;
        System.out.println("索引为" + index + "的元素值为：" + intArray[index]);

        // 支持直接初始化数组，不能声明数组的长度
        int[] intArray2 = {10, 20, 30};
        // ArrayIndexOutOfBoundsException
        // intArray2[3] = 30;
        int index2 = 1;
        System.out.println(index2 + "位置元素的值：" + intArray2[index2]);
        System.out.println("数组长度：" + intArray2.length);

        // 字符串数组
        String[] sArray = new String[2];
        sArray[0] = "BO";
        sArray[1] = "SUN";
        System.out.println(sArray[1]);

        // 字符串数组，创建时直接添加元素
        String[] sArray2 = { "aa", "dd" };
        System.out.println("这是String类型:  " + sArray2[0].getClass().getName());
        System.out.println("这是什么类型: " + sArray.getClass().getName());
        Bicycle[] bicycles;
    }
}
