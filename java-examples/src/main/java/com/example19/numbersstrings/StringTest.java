package com.example19.numbersstrings;

import javax.swing.plaf.basic.BasicViewportUI;

public class StringTest {
    public static void main(String[] args) {
        // stringEquals()
        // getStringLiteral();
        // getConcatenatingStrings();
        // getConvertingStringsToNumbers();
        // getConvertingNumbersToStrings();
        // getManipulating();
        // getReplace();
        // getEquals();
        // getStringBuilder();
        // geteff();
        stringSplicingTest();
    }

    private static void stringEquals() {
        String str1 = "hello";
        String str2 = new String("hello");
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);
        String str3 = str1.intern();

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str3);
    }

    private static void getStringLiteral() {
        String h1 = "Hello World";
        String h2 = "Hello World";
        System.out.println(h1 == h2);

        String o1 = new String("Hello World");
        String o2 = new String("Hello World");
        System.out.println(o1 == o2);

        System.out.println(h1.length());
        System.out.println(o1.length());

    }

    private static void getConcatenatingStrings() {
        String hello = "Hello" + " World";
        System.out.println(hello);
        String h1 = "Hello World";
        System.out.println(hello == h1);

        String h = "Hello";
        String w = " World";
        String hw = h + w;
        System.out.println(hw);
        System.out.println(hw == hello);
    }

    private static void getConvertingStringsToNumbers() {
        String nString = "110";
        int num = Integer.parseInt(nString);
        double dnum = Double.parseDouble(nString);
        System.out.println(num + 7);
        System.out.println(dnum + 7);

        // NumberFormatException 异常
        // int num2 = Integer.parseInt("BO");
    }

    private static void getConvertingNumbersToStrings() {
        int num = 110;
        String nString = "" + num;
        System.out.println("string的值：" + nString + "；长度为：" + nString.length());
        String nString2 = Integer.toString(num);
        String nString3 = String.valueOf(num);
        System.out.println(nString2 + "/" + nString3);
    }

    private static void getManipulating() {

        String simple = "Hello World";
        String simToLowCase = simple.toLowerCase();
        System.out.println(simToLowCase);
        System.out.println(simple.toUpperCase());
        System.out.println(simple);

        System.out.println(simple.substring(6));
        System.out.println(simple.substring(0, 5));

        String fileName = "Lecture01.pptx";
        int index = fileName.lastIndexOf(".");
        System.out.println("文件名称：" +
                fileName.substring(0, index));
        System.out.println("文件扩展名：" +
                fileName.substring(index + 1));
    }

    private static void getReplace() {
        String dString = "2018/10/10 08：30";
        String fString = dString.replaceAll("/", "-").replaceAll("：", ":");
        System.out.println(fString);
    }

    private static void getEquals() {
        String s1 = "Hello World";
        String s2 = s1.toLowerCase();
        String s3 = new String("Hello World");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1 == s3);
    }

    private static void getStringBuilder() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            builder.append("学号：" + i + "; ");
        }
        System.out.println(builder.toString());
    }

    //  +操作符的字符串拼接底层依然基于stringbuilder。但循环的每次拼接均创建builder对象
    private static void geteff() {
        int n = 100_000;
        long start1 = System.nanoTime();
        String msg = "";
        for (int i = 0; i < n; i++) {
            msg = msg + "学号：" + i + ";";
        }
        long end1 = System.nanoTime();
        System.out.println(end1 - start1);

        long start2 = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append("学号：").append(i).append(";");
        }
        String msg2 = builder.toString();
        long end2 = System.nanoTime();
        System.out.println(end2 - start2);
        System.out.println(msg.equals(msg2));
    }

    private static void stringSplicingTest() {
        int n1 = 10;
        int n2 = 20;
        System.out.println(n1 + n2);
        System.out.println("Total: " + n1 + n2);
        // 由于括号的优先级高，因此先执行计算，后按字符串拼接
        System.out.println("Total: " + (n1 + n2));
    }
}
