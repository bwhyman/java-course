package com.example41.bio.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        // 监听本地端口
        ServerSocket ss = new ServerSocket(3000);
        // 阻塞，直至有客户端连接进入
        Socket socket = ss.accept();
        System.out.println("客户端连接中... ...");
        byte[] by = new byte[1024];
        while (true) {
            try {
                //建立输入流
                InputStream is = socket.getInputStream();

                System.out.println(is.read());
                //将输入流里的字节读到字节数组里，并返回读的字节数
                /*int length = is.read(by);
                String str = new String(by, 0, length);*/
                //System.out.println("消息：" + str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
