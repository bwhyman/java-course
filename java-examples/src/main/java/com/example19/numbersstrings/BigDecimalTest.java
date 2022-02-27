package com.example19.numbersstrings;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        float t1 = 0.2F;
        float t2 = 0.1F;
        System.out.println(0.2 + 0.1);
        BigDecimal b1 = new BigDecimal("0.2");
        BigDecimal b2 = new BigDecimal("0.1");
        System.out.println(b1.add(b2));


        System.out.println(0.3 - 0.1);
        BigDecimal b3 = new BigDecimal("0.3");
        BigDecimal b4 = new BigDecimal("0.1");
        System.out.println(b3.subtract(b4));

        System.out.println(0.2 * 0.1);
        System.out.println(new BigDecimal("0.2")
                .multiply(new BigDecimal("0.1")));
    }
}
