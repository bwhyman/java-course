package com.example20.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    private static final List<User> USERS = create();
    private static List<User> create() {
        User u1 = new User("BO");
        User u2 = new User("SUN");
        User u3 = new User("SUN");
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        return users;
    }

    public static void main(String[] args) {
        // getSize();
        // forByIndex();
        // updateElement();
        // addRepeatElement();
        // removeElement();
        // removeElementByIndex();
        // listToArray();
        arrayToList();
    }

    /**
     * 声明与添加元素
     */
    private static void addSubClass() {
        USERS.add(new Student());
    }

    /**
     * 基本方法
     */
    private static void getSize() {
        System.out.println(USERS.size());
        System.out.println(USERS.isEmpty());
    }

    /**
     * 基于索引的for循环
     */
    private static void forByIndex() {
        for (int i = 0; i < USERS.size(); i++) {
            System.out.println(USERS.get(i).getName());
        }
    }

    /**
     * 基于foreach循环语句
     */
    private static void forEach() {
        for (User u : USERS) {
            System.out.println(u.getName());
        }
    }

    /**
     * 更新元素
     */
    private static void updateElement() {
        User user = USERS.get(0);
        user.setName("ZHANG");
        for (User u : USERS) {
            System.out.println(u.getName());
        }
    }

    /**
     * 添加重复元素
     */
    private static void addRepeatElement() {
        User user = USERS.get(0);
        USERS.add(user);
        for (User u : USERS) {
            System.out.println(u.getName());
        }
    }

    /**
     * 基于属性值，判断移除元素
     */
    private static void removeElement() {
        for (User u : USERS) {
            if ("SUN".equals(u.getName())) {
                USERS.remove(u);
            }
        }

        for (User u : USERS) {
            System.out.println(u.getName());
        }
    }

    /**
     * 通过基本for循环。基于属性值，判断移除元素
     */
    private static void removeElementByIndex() {
        for (int i = 0; i < USERS.size(); i++) {
            if ("SUN".equals(USERS.get(i).getName())) {
                USERS.remove(i);
            }
        }
        for (User u : USERS) {
            System.out.println(u.getName());
        }
    }

    /**
     * 集合转数组
     */
    private static void listToArray() {
        User[] users = USERS.toArray(new User[0]);
        for (User u : users) {
            System.out.println(u.getName());
        }
    }

    /**
     * 数组转集合，有问题
     */
    private static void arrayToList() {
        User[] users = USERS.toArray(new User[0]);

        List<User> userList = Arrays.asList(users);
        userList.add(new User());
        for (User u : userList) {
            System.out.println(u.getName());
        }
    }
}
