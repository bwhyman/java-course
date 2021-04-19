package p6.collection;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        User u1 = new User(1, "BO", "哈尔滨");
        User u2 = new User(2, "SUN", "北京");
        User u3 = new User(3, "ZHANG", "哈尔滨");
        User u4 = new User(4, "LIU", "北京");
        User u5 = new User(5, "ZHAO", "上海");
        Set<User> users = new HashSet<>();
        users.add(u1); users.add(u2); users.add(u3);
        users.add(u4); users.add(u5);
        toMap(users);
    }

    private static void toList(Set<User> users) {
        List<User> userList = new ArrayList<>(users);
    }

    private static void remove(Set<User> users, int id) {
        Iterator<User> userIterator = users.iterator();
        while (userIterator.hasNext()) {
            User u = userIterator.next();
            if (id == u.getId()) {
                userIterator.remove();
            }
        }
    }

    private static void toMap(Set<User> users) {
        Map<String, Set<User>> map = new HashMap<>();
        for (User u : users) {
            /*Set<User> set = map.getOrDefault(u.getCity(), new HashSet<>());
            set.add(u);
            map.put(u.getCity(), set);*/
            /*String city = u.getCity();
            if (map.get(city) == null) {
                map.put(city, new HashSet<>());
            }
            map.get(city).add(u);*/
            // 基于键返回map中对应的值；没有则执行第2参数的函数，注入键创建值，并将键值对置于map，并返回值
            map.computeIfAbsent(u.getCity(), k -> new HashSet<>())
                    .add(u);
        }
    }
}
