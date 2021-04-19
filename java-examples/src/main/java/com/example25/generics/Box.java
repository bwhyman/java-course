package com.example25.generics;

public class Box<T> {
    private T t;
    public Box() {
    }
    public Box(T t) {
        this.t = t;
    }
    public T getT() {
        return t;
    }
    public void setT(T t) {
        this.t = t;
    }
}
