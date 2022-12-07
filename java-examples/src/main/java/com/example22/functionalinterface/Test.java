package com.example22.functionalinterface;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyFunction f = x -> x * x;
        List<Integer> nums = List.of(4, 6, 7);
        MyList list = new MyList(nums);
        list.forEach(x -> x * x * x);
    }
}
