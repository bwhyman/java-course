package com.example02.clazz;

public class ClassTest {
    public static void main(String[] args) {
        // 创建table对象
        createTable();
    }
    private static void createTable() {
        Table table = new Table(1.5F, 0.5F, 1F, "课桌");
        Table table1 = new Table(1.5F, 0.5F, 1F, "课桌");
        System.out.println(table == table1);

        long creditCardNumber = 1234567890123456L;
        System.out.println(creditCardNumber);
    }
}
