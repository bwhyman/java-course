package com.example22.functionalinterface;

import com.example20.collection.User;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyFunction f = x -> {
            return x * x;
        };
        List<Integer> nums = new ArrayList<>();
        nums.add(4); nums.add(6); nums.add(7);
        MyList list = new MyList(nums);
        list.forEach(x -> {
            return x * x * x;
        });
    }
}
