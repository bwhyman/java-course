package com.example20.collection;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        //getAddElement();
        testSequencedSet();
    }

    /**
     * 无基于索引的方法；
     */
    private static void getAddElement() {
        Set<User> users = new HashSet<>();
        User user = new User("BO");
        User user1 = new User("SUN");
        users.add(user);
        users.add(user1);
        System.out.println(users.size());
        users.add(user);
        System.out.println(users.size());
        for (User u : users) {
            System.out.println(u.getName());
        }

        List<User> userList = new ArrayList<>(users);

    }

    private static void testSequencedSet() {
        SequencedSet<User> users = new LinkedHashSet<>();
        User user = new User("BO");
        User user1 = new User("SUN");
        users.add(user);
        users.add(user1);
        System.out.println(users.size());
        users.add(user);
        // 按顺序输出
        for (User u : users) {
            System.out.println(u.getName());
        }
        SequencedSet<User> reversed = users.reversed();
        for (User u : reversed) {
            System.out.println(u.getName());
        }
    }

}
