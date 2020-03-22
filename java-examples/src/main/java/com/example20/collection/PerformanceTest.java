package com.example20.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PerformanceTest {
    // 1百万
    private static final int NUM = 1_000_000;
    // 产生100万内一个随机数
    private static final int RANDOM = new Random().nextInt(NUM);

    public static void main(String[] args) {
        List<User> uArray = createList(true);
        List<User> uLinked = createList(false);
        forEach(uArray, true);
        forEach(uLinked, false);
        System.out.println("随机数：" + RANDOM);
        getByIndex(uArray, true);
        getByIndex(uLinked, false);
        removeElement(uArray, true);
        removeElement(uLinked, false);
        removeAll(uArray, true);
        removeAll(uLinked,false);
        removeAllBySubList(uArray, true);
        removeAllBySubList(uLinked, false);
    }

    private static List<User> createList(boolean array) {
        long start = System.nanoTime();
        List<User> users = null;
        if (array) {
            users = new ArrayList<>();
        } else {
            users = new LinkedList<>();
        }
        for (int i = 0; i < NUM; i++) {
            User u = new User();
            users.add(u);
        }
        long end = System.nanoTime();
        String title = array ? " ArrayList创建时间：" : "LinkedList创建时间：";
        System.out.println(title + (end - start));
        return users;
    }

    private static void forEach(List<User> users, boolean array) {
        long start = System.nanoTime();
        for (User user : users) {
            user.getName();
        }
        long end = System.nanoTime();
        String title = array ? " ArrayList foreach遍历：" : "LinkedList foreach遍历：";
        System.out.println(title + (end - start));
    }


    private static void getByIndex(List<User> users, boolean array) {
        long start = System.nanoTime();
        User u = users.get(RANDOM);
        long end = System.nanoTime();
        String title = array ? " ArrayList基于随机数索引获取元素：" : "LinkedList基于随机数索引获取元素：";
        System.out.println(title + (end - start));
    }


    private static void removeElement(List<User> users, boolean array) {
        long start = System.nanoTime();
        users.remove(RANDOM);
        long end = System.nanoTime();
        String title = array ? " ArrayList基于随机数索引移除元素：" : "LinkedList基于随机数索引移除元素：";
        System.out.println(title + (end - start));
    }

    private static void removeAll(List<User> users, boolean array) {
        long start = System.nanoTime();
        for (int i = 0; i < RANDOM; i++) {
            users.remove(0);
        }
        long end = System.nanoTime();
        String title = array ? " ArrayList删除随机数索引前全部元素：" : "LinkedList删除随机数索引前全部元素：";
        System.out.println(title + (end - start));
    }

    private static void removeAllBySubList(List<User> users, boolean array) {
        long start = System.nanoTime();
        users.subList(0, RANDOM).clear();
        long end = System.nanoTime();
        String title = array ? " ArrayList删除随机数索引前全部元素：" : "LinkedList删除随机数索引前全部元素：";
        System.out.println(title + (end - start));
    }
}
