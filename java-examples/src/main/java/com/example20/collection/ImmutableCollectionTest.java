package com.example20.collection;

import java.util.List;
import java.util.Map;

public class ImmutableCollectionTest {
    public static void main(String[] args) {
        // getImmutableList();
        // getImmutableList2();
getImmutableMap();
    }

    /**
     * 创建不可变集合，遍历
     * 添加元素，异常
     */
    private static void getImmutableList() {
        User user = new User("BO");
        User user2 = new User("SUN");
        User user3 = new User("ZHANG");
        List<User> users = List.of(user, user2, user3);
        for (User u : users) {
            System.out.println(u.getName());
        }
        System.out.println(users.getClass().getName());

    }

    /**
     * 不可变集合持有的依然是元素对象的引用
     */
    private static void getImmutableList2() {
        User user = new User("BO");
        User user2 = new User("SUN");
        User user3 = new User("ZHANG");
        List<User> users = List.of(user, user2, user3);
        for (User u : users) {
            u.setName("BO");
        }
        for (User u : users) {
            System.out.println(u.getName());
        }
    }

    /**
     * 创建不可变Map对象
     */
    private static void getImmutableMap() {
        User user = new User("BO");
        User user2 = new User("SUN");
        User user3 = new User("ZHANG");
        Map<Integer, User> userMap = Map.of(1, user, 2, user2, 3, user3);

        System.out.println(userMap.get(1).getName());

    }

}
