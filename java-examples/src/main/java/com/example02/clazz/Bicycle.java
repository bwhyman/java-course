package com.example02.clazz;

public class Bicycle {
    private int cadence = 0;
    private int speed = 0;
    private int gear = 1;
    // 改变频率
    void changeCadence(int newValue) {
        cadence = newValue;
    }
    // 改变档位
    void changeGear(int newValue) {
        gear = newValue;
    }
    // 改变速度
    void speedUp(int increment) {
        speed = speed + increment;
    }
    // 刹车降速
    void applyBrakes(int decrement) {
        speed = speed - decrement;
    }
}
