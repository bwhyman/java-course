package com.example10.staticvariable;

public class Student {
    public static final String MALE = "male";
    public static final String FEMALE = "female";
    private String name;
    private String sex;

    public Student(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
