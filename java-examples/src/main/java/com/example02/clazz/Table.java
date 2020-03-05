package com.example02.clazz;

public class Table {
    private float length;
    private float width;
    private float height;
    private String type;
    public Table(float length, float width, float height, String type) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
