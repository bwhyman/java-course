package com.example29.highlevelconcurrency.structuredtaskscope;

import java.util.List;
import java.util.concurrent.StructuredTaskScope;
import java.util.stream.Stream;

public class Test {
    static void main() throws InterruptedException {
        //test();
        //test2();
        test3();
    }

    private static void test() {
        // 创建结构化并发任务作用域
        // 任务作用域在try块后自动关闭并结束
        try (var scope = StructuredTaskScope.open()) {
            // 在作用域内，创建子任务
            // 子任务，默认即基于虚拟线程执行
            StructuredTaskScope.Subtask<String> task = scope.fork(() -> {
                IO.println(Thread.currentThread());
                return "Subtask hello";
            });
            StructuredTaskScope.Subtask<String> task2 = scope.fork(() -> {
                IO.println(Thread.currentThread());
                return "Subtask2 world";
            });
            // 作用域，阻塞等待内部所有异步子任务执行完毕
            // 基于虚拟线程的阻塞代价可忽略不计
            scope.join();
            // 从异步执行的子任务中，获取返回结果
            String r1 = task.get();
            String r2 = task2.get();
            IO.println(Thread.currentThread()+ ": " + r1 + ", " + r2 );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void test2() {
        var start = System.currentTimeMillis();
        List<String> r1 = UserService.getUserNames();
        List<String> r2 = UserService.getCourseNames();
        var end = System.currentTimeMillis();
        IO.println("seconds: " + ((end - start) / 1000));
    }

    private static void test3() throws InterruptedException {
        var start = System.currentTimeMillis();
        try(var scope = StructuredTaskScope.open()) {
            var userNamesT = scope.fork(() -> UserService.getUserNames());
            var courseNameT = scope.fork(() -> UserService.getCourseNames());
            scope.join();
            var r1 = userNamesT.get();
            var r2 = courseNameT.get();
        }
        var end = System.currentTimeMillis();
        IO.println("seconds: " + ((end - start) / 1000));
    }

    private static void test4() throws InterruptedException {
        var start = System.currentTimeMillis();
        try(var scope = StructuredTaskScope.open(StructuredTaskScope.Joiner.allSuccessfulOrThrow())) {
            var userNamesT = scope.fork(() -> UserService.getUserNames());
            var courseNameT = scope.fork(() -> UserService.getCourseNames());
            scope.join();
            var r1 = userNamesT.get();
            var r2 = courseNameT.get();
        }
        var end = System.currentTimeMillis();
        IO.println("seconds: " + ((end - start) / 1000));
    }

}
