package com.example19.numbersstrings;

import java.math.BigDecimal;

public class BigDecimalTest {
    public static void main(String[] args) {
        float t1 = 0.2F;
        float t2 = 0.1F;
        System.out.println(0.2 + 0.1);
        BigDecimal b1 = new BigDecimal("0.2");
        BigDecimal b2 = new BigDecimal("0.1");
        // 包含与基本数据类型的转换
        float t3 = b1.add(b2).floatValue();
        System.out.println(t3);

        System.out.println(0.3 - 0.1);
        BigDecimal b3 = new BigDecimal("0.3");
        BigDecimal b4 = new BigDecimal("0.1");
        System.out.println(b3.subtract(b4));

        System.out.println(0.2 * 0.1);
        // 包含与string/基本数据类型封装类型的转换
        String result = new BigDecimal("0.2")
                .multiply(new BigDecimal("0.1")).toString();
        System.out.println(result);
    }
}
