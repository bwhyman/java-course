package com.example20.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        getAddElement();
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

}
