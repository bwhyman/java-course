package com.experiment01;

public class SummationTest {
    public static void main(String[] args) {
        // 数字
        double n = 3;
        // 循环次数
        int repeat = 4;
        double current = 0;
        double result = 0;
        for (int i = 0; i < repeat; i++) {
            current = current + n * Math.pow(10, i);
            result += current;
        }
        System.out.println(result);
    }
}
