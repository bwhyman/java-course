package com.example22.functionalinterface;

import java.util.List;

public class MyList {
    private List<Integer> list;

    public MyList(List<Integer> list) {
        this.list = list;
    }

    public void forEach(MyFunction f) {
        for (Integer i : list) {
            int r = f.getValue(i);
            System.out.println(r);
        }
    }
}
