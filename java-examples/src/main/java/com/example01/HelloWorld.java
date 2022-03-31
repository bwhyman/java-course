package com.example01;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        String x = "1";
        System.out.println(Arrays.toString(x.getBytes(StandardCharsets.UTF_8)));
        byte d = (byte) 127;
        System.out.println(d);
        System.out.println(Arrays.toString(intTo(256)));
    }

    private static byte[] intTo(int i) {
        byte[] b = new byte[4];
        b[0] = (byte) (i & 0xff);
        b[1] = (byte) (i >> 8 & 0xff);
        b[2] = (byte) (i >> 16 & 0xff);
        b[3] = (byte) (i >> 24 & 0xff);
        return b;
    }
}
