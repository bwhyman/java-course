package com.experiment02.entity;

public class User {
    private String name;
    private double balance;
    private String address;

    public User(String name, double balance, String address) {
        this.name = name;
        this.balance = balance;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
