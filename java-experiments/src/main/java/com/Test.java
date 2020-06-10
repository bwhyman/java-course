package com;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        String str = "学java";
        System.out.println(str.getBytes(StandardCharsets.UTF_16LE).length);
    }
}
