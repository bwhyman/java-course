package com.example06.accesslevel;

public class MyLevel {
    private String name = "BO";
    private void in() {
        System.out.println(name);
    }
    public void out() {
        in();
    }
    protected final void doGet() {}
}
    /*public String getName() {
        return name;
    }


    void setName(String name) {
        this.name = name;
    }*/
