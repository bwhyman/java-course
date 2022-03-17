package com.experiment01;

import java.util.Arrays;

public class BubbleSortTest {
    public static void main(String[] args) {
        sort();
        System.out.println("+++++++++++");
        sort2();
        System.out.println("+++++++++++");
        sort3();
    }

    /**
     * 基本冒泡排序
     */
    private static void sort() {
        int[] ints = {8, 3, 4, 22, 1};
        // 从第1个元素开始，而最后一个元素无需和自己比较
        for (int i = 0; i < ints.length - 1; i++) {
            // 从当前元素的后一个开始
            for (int j = i + 1; j < ints.length; j++) {
                // 比较，并将小的置换到前面
                if (ints[i] > ints[j]) {
                    int temp = ints[j];
                    ints[j] = ints[i];
                    ints[i] = temp;
                }
            }
        }
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     *
     */
    private static void sort2() {
        int[] ints = {8, 3, 4, 22, 1};
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                // 无需置换，但需要比较2次
                int min = Math.min(ints[i], ints[j]);
                int max = Math.max(ints[i], ints[j]);
                ints[i] = min;
                ints[j] = max;
            }
        }
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * 集合流封装的排序操作
     */
    private static void sort3() {
        int[] ints = {8, 3, 4, 22, 1};
        Arrays.stream(ints)
                .sorted()
                .forEach(System.out::println);
    }
}
