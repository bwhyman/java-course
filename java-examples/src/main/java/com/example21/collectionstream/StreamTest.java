package com.example21.collectionstream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    private static final List<Apple> APPLES = create();

    private static List<Apple> create() {
        Apple a = new Apple(1, Apple.Color.RED, 200);
        Apple a2 = new Apple(2, Apple.Color.GREEN, 250);
        Apple a3 = new Apple(3, Apple.Color.RED, 260);
        Apple a4 = new Apple(4, Apple.Color.GREEN, 230);
        List<Apple> apples = new ArrayList<>();
        apples.add(a);
        apples.add(a2);
        apples.add(a3);
        apples.add(a4);
        return apples;
    }

    public static void main(String[] args) {
        // forEach();
        /*filter(Apple.Color.RED)
                .forEach(a -> System.out.println(a.getId()));*/
        // map();
        // sorted();
        // sortedReversed();
        // collect();
        collectGroupingBy2();
    }

    /**
     * foreach循环
     * forEach()方法，简写
     */
    private static void forEach() {
        for (Apple a : APPLES) {
            System.out.println(a.getWeight());
        }
        APPLES.forEach(a -> System.out.println(a.getWeight()));
    }

    /**
     * 原实现。返回指定颜色的全部苹果
     */
    private static List<Apple> getRedApples(Apple.Color c) {
        List<Apple> reds = new ArrayList<>();
        for (Apple a : APPLES) {
            if (c == a.getColor()) {
                reds.add(a);
            }
        }
        return reds;
    }

    /**
     * 基于stream的过滤
     * 修改方法返回值，方法链
     * 比较源/新集合
     *
     * @param c
     */
    private static List<Apple> filter(Apple.Color c) {
        return APPLES.stream()
                .filter(a -> a.getColor() == c)
                .collect(Collectors.toList());
    }

    /**
     * 过滤指定颜色，且大于等于指定重量的苹果。2次过滤
     *
     * @param c
     * @param weight
     */
    private static void filter(Apple.Color c, int weight) {
        APPLES.stream()
                .filter(a -> a.getColor() == c)
                .filter(a -> a.getWeight() >= weight)
                .collect(Collectors.toList())
                .forEach(a -> System.out.println(a.getId()));

    }


    /**
     * 将重量映射为新集合，遍历打印
     * 简写
     */
    private static void map() {
        APPLES.stream()
                .map(Apple::getWeight)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    /**
     * 以重量顺序排序
     */
    private static void sorted() {
        APPLES.stream()
                .sorted(Comparator.comparing(Apple::getWeight))
                .collect(Collectors.toList())
                .forEach(a -> System.out.println(a.getWeight()));
    }

    /**
     * 以ID逆序排序
     */
    private static void sortedReversed() {
        APPLES.stream()
                .sorted(Comparator.comparing(Apple::getId).reversed())
                .collect(Collectors.toList())
                .forEach(a -> System.out.println(a.getId()));
    }

    /**
     * 获取颜色，分别按list/set聚合
     */
    private static void collect() {
        APPLES.stream()
                .map(Apple::getColor)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

    }

    /**
     * Map操作。基于颜色分组
     */
    private static void collectGroupingBy() {
        Map<Apple.Color, List<Apple>> map = APPLES.stream()
                .collect(Collectors.groupingBy(Apple::getColor));

    }

    /**
     * 以ID为键，苹果对象为值。自定义键值对
     * forEach遍历
     */
    private static void collectGroupingBy2() {
        APPLES.stream()
                .collect(Collectors.toMap(Apple::getId, a -> a))
                .forEach((k, v) -> {
                    System.out.println(k + "/" + v.getColor());
                });

    }

    /**
     * 函数中，只能操作函数体外的常量
     */
    private static void finalValue() {
       int count = 0;
        APPLES.forEach(a -> {
            System.out.println(count);
        });
    }

    /**
     * 2组过滤相同
     */
    private static void getFilter() {
        Apple a1 = new Apple(1, Apple.Color.RED, 200);
        Apple a2 = new Apple(5, Apple.Color.GREEN, 240);
        List<Apple> newApples = List.of(a1, a2);
        List<Apple> oldApples = APPLES;
        List<Apple> apples = new ArrayList<>();
        for (Apple a : newApples) {
            for (Apple oa : oldApples) {
                if (a.getId() == oa.getId()) {
                    apples.add(a);
                }
            }
        }
        apples.forEach(a -> System.out.println(a.getId()));
        System.out.println("--------------");
        List<Apple> apples2 = newApples.stream()
                .filter(a -> oldApples.stream()
                        .anyMatch(oa -> oa.getId() == a.getId()))
                .collect(Collectors.toList());

        apples2.forEach(a -> System.out.println(a.getId()));
    }
}
