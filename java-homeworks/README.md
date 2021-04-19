# Java Homeworks

### Homework-06
```java
public class User {
    private int id;
    private String name;
    private String city;
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    // 省略getter/setter方法
}
```
给定User类型，未知的Set集合数据。即不知道集合中有多少user对象，不知道用户居住在多少个城市。  
实现以下方法，以城市名称为键，在此城市的所用用户为值，保存为Map。  
```java
private static void toMap(Set<User> users) {
    
}
```
