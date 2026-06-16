package com.example30.io;

import java.io.*;

public class IOTest {
    public static void main(String[] args) throws IOException {
        //getByteStreams();
        //getAutoCloseable();
        // getByteArray();
        getStringsInText();
    }

    /**
     * 仅用于了解IO输入输出过程，勿使用
     *
     * @throws IOException
     */
    private static void getByteStreams() throws IOException {
        try (FileInputStream in = new FileInputStream("D:/test/input.txt");
             FileOutputStream out = new FileOutputStream("D:/test/output.txt");) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
    }

    private static void getAutoCloseable() {
        try (MyResource r = new MyResource()) {
            System.out.println("Try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Catch");
        } finally {
            System.out.println("Finally");
        }
    }

    /**
     *
     * @throws IOException
     */
    private static void getTryWithResources2() throws IOException {
        FileInputStream in = new FileInputStream("D:/test/input.txt");
        FileOutputStream out = new FileOutputStream("D:/test/output.txt");
        try (in; out) {
            int c = 0;
            while ((c = in.read()) != -1) {
                System.out.println("读取字节的十进制整数：" + c);
                out.write(c);
            }
        }
    }

    /**
     * 基于字节数缓冲区的实现
     *
     * @throws IOException
     */
    private static void getByteArray() {
        try(FileInputStream in = new FileInputStream("D:/test/input.txt");
            FileOutputStream out = new FileOutputStream("D:/test/output.txt");) {
            // 创建字节数组缓冲区
            byte[] buffer = new byte[4];
            // 读出的长度
            int len;
            // 从输入流读取字节到缓冲区，并返回本次读取的字节长度，阻塞
            while ((len = in.read(buffer)) != -1) {
                // 从缓冲区写入输出流，数组起始位置，读取长度
                out.write(buffer, 0, len);
            }
        } catch (IOException e) {}
    }


    /**
     * Java9引入，封装基于字节数组的实现
     * 字节数组长度8192
     */
    private static void getTransferTo() throws IOException {
        try (FileInputStream is =
                     new FileInputStream("D:/test/Twinkle Twinkle Little Star.mp4");
             FileOutputStream os = new FileOutputStream("D:/test/mov.mp4")) {
            is.transferTo(os);
        }
    }

    /**
     * 基于文本文件的具体字符集，读取
     *
     * @throws IOException
     */
    private static void getStringsInText() throws IOException {
        try (FileInputStream is =
                     new FileInputStream("D:/test/cn.txt")) {
            byte[] bytes = is.readAllBytes();
            System.out.println(new String(bytes));
        }
    }
}
