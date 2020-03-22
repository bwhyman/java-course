package com.example20.collection;

public class User {
    public static final String HAERBIN = "哈尔滨";
    public static final String BEIJING = "北京";
    private int id;
    private String name;
    private String city;

    public User() {
    }
    public User(String name) {
        this.name = name;
    }
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
