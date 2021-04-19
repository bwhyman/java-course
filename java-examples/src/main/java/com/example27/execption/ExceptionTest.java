package com.example27.execption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ExceptionTest {

    public static void main(String[] args) {
        // getCheckedException1();
        // getUncheckedException1();
        // etUncheckedException2();
        // getCheckedException2();
        // getTryCatchFinally1();
        // System.out.println("返回的结果："  +getTryCatchFinally2());
        // getTryCatchFinally3();
    }

    private static void getCheckedException1() {
        try {
            Files.readString(Path.of("A:/aa.aa"));
            Thread.sleep(1000);
        } catch (IOException e) {
            System.err.println("捕获IOException异常");
        } catch (InterruptedException e) {
            System.err.println("捕获InterruptedException异常");
        }
    }

    private static void getUncheckedException1() {
        System.out.println("异常前");
        List.of("apple", "banana").get(1);
        System.out.println("异常后");
    }
    private static void getUncheckedException2() {
        System.out.println("异常前");
        try {
            //List.of("apple", "banana").get(100);
            List.of("apple", "banana").add("lemon");
        } catch (IndexOutOfBoundsException  e) {
            System.out.println("索引越界");
        } catch (UnsupportedOperationException e) {
            System.out.println("向不可变集合添加了元素");
        }
        System.out.println("异常后");
    }

    private static void getCheckedException2() {
        try {
            System.out.println("try块内异常前");
            Files.readString(Path.of("A:/aa.aa"));
            System.out.println("try块内异常后");
        } catch (IOException e) {
            System.out.println("catch块内");
        }
        System.out.println("try/catch块后");
    }

    // A:/aa.aa; G:/example.txt
    private static void getTryCatchFinally1() {
        try {
            System.out.println("try块内异常前");
            Files.readString(Path.of("A:/aa.aa"));
            System.out.println("try块内异常后");
        } catch (IOException e) {
            System.out.println("catch块内");
        } finally {
            System.out.println("finally块内");
        }
        System.out.println("finally块后");
    }

    private static String getTryCatchFinally2() {
        try {
            System.out.println("try块内异常前");
            Files.readString(Path.of("G:/example.txt"));
            System.out.println("try块内异常后");
            return "try中结果";
        } catch (IOException e) {
            System.out.println("catch块内");
        } finally {
            System.out.println("finally块内");
        }
        System.out.println("finally块后");
        return "finally后结果";
    }

    private static void getTryCatchFinally3() {
        try {
            System.out.println("try块内异常前");
            Thread.sleep(1000);
            Files.readString(Path.of("A:/aa.aa"));
            System.out.println("try块内异常后");
        } catch (InterruptedException e) {
            System.out.println("catch块内: InterruptedException");
        } catch (IOException e) {
            System.out.println("catch块内: IOException");
        } finally {
            System.out.println("finally块内");
        }
    }
}
