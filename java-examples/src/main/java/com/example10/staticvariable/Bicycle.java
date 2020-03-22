package com.example10.staticvariable;

public class Bicycle {
    private int gear;
    private static int amount = 0;
    public Bicycle() {
        amount++;
        System.out.println("Bicycle()");
    }

    public static int getAmount() {
        return amount;
    }


    public int getGear() {
        getAmount();
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }
}
