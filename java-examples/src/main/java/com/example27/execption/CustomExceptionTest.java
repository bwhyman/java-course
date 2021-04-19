package com.example27.execption;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomExceptionTest {
    public static void main(String[] args) throws IOException {
        try {
            getThrows1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static void getThrows1() throws IOException, InterruptedException {
        Files.readString(Path.of("A:/aa.aa"));
        Thread.sleep(1000);
    }

    private static void getMyException() {
        if (1 == 1) {
            throw new MyException("1 == 1，错了!");
        }
    }

    private static void getMyException2() {
        try {
            Files.readString(Path.of("A:/aa.aa"));
        } catch (IOException e) {
            throw new MyException("读取文件错误！" + e.getMessage());
        }
    }

}
