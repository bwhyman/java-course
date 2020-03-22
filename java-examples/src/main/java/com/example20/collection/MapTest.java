package com.example20.collection;

import java.util.*;

public class MapTest {
    private static final List<User> USERS = create();

    private static List<User> create() {
        User u = new User(1, "BO", User.HAERBIN);
        User u1 = new User(2, "SUN", User.BEIJING);
        User u2 = new User(3, "ZHANG", User.BEIJING);
        User u3 = new User(4, "LIU", User.HAERBIN);
        List<User> users = new ArrayList<>();
        users.add(u);
        users.add(u1);
        users.add(u2);
        users.add(u3);
        return users;
    }

    public static void main(String[] args) {
        //putMapBase();
        // getMap();
        // putListValue();
        getMapStringKey();
    }

    /**
     * 创建基本键值对；获取
     */
    private static void putMapBase() {
        Map<String, String> map = new HashMap<>();
        map.put("BO", "956");
        map.put("SUN", "925");
        System.out.println(map.size());
        System.out.println(map.get("BO"));
        map.put("BO", "1201");
        System.out.println(map.get("BO"));
    }

    /**
     * 以集合中user对象的ID为key，user对象本身为value
     * size()；get()；
     * 指定的key没有value？
     */
    private static void getMap() {
        Map<Integer, User> map = new HashMap<>();
        for (User u : USERS) {
            map.put(u.getId(), u);
        }
        System.out.println(map.size());
        System.out.println(map.get(1).getCity());
        System.out.println(map.get(100).getCity());
    }

    /**
     * 以城市名称为key，以居民为value
     * 每个城市住着多个人？
     */
    private static void putListValue() {
        List<User> hList = new ArrayList<>();
        hList.add(USERS.get(0));
        hList.add(USERS.get(3));
        List<User> bList = new ArrayList<>();
        bList.add(USERS.get(1));
        bList.add(USERS.get(2));
        Map<String, List<User>> map = new HashMap<>();
        map.put(User.HAERBIN, hList);
        map.put(User.BEIJING, bList);
        System.out.println(map.size());

        for (User u : map.get(User.BEIJING)) {
            System.out.println(u.getName());
        }
    }

    /**
     * 遍历User List集合，以城市名称为key，对应的居民集合为value自动分组。
     * 即，遍历的同时基于不确定的城市名称，创建对应集合，再分组
     */
    private static void putListValue2() {

    }

    /**
     * 字符串key的特殊性
     */
    private static void getMapStringKey() {
        String n = new String("BO");
        String n2 = new String("BO");
        System.out.println(n.equals(n2));
        System.out.println(n == n2);
        Map<String, String> map = new HashMap<>();
        map.put(n, "956");
        map.put(n2, "925");
        System.out.println(map.size());
    }

    private static void getKeySet() {
        User user = new User(1, "BO", "哈尔滨");
        User user2 = new User(2, "SUN", "北京");
        User user3 = new User(3, "ZHANG", "上海");
        Map<Integer, User> uMap = new HashMap<>();
        uMap.put(user.getId(), user);
        uMap.put(user2.getId(), user2);
        uMap.put(user3.getId(), user3);
        Set<Integer> nMapKeys = uMap.keySet();
        for (int i : nMapKeys) {
            System.out.println(i);
        }
    }

    /**
     * Map不支持foreach语句
     */
    private static void remove() {
        Map<Integer, User> uMap = new HashMap<>();
        for (User u : USERS) {
            uMap.put(u.getId(), u);
        }
        uMap.remove(1);
        System.out.println(uMap.size());
    }
}
