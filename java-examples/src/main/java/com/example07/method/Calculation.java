package com.example07.method;

import java.util.Calendar;

public class Calculation {
    // 声明一个普通的方法
    public double calculate(double Weighted, double average, int point, int level) {
        // 实现具体计算逻辑
        return 0;
    }

    // 方法的重载
    public void list(int groupId, int type) {
        calculate(10, 8, 7, 4);
    }
    public void list(int groupId, Calendar startTime, Calendar endTime) {}
    public void list(int groupId, int firstResult, int maxResults) {}
    public void list(int groupId,  int type, int firstResult, int maxResults) {}
}
