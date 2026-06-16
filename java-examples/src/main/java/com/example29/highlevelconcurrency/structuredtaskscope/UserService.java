package com.example29.highlevelconcurrency.structuredtaskscope;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UserService {

    public static List<String> getUserNames() {
        // 模拟耗时阻塞业务
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return List.of("a", "b", "c");
    }

    public static List<String> getCourseNames() {
        // 模拟耗时阻塞业务
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return List.of("x", "y", "z");
    }
}
