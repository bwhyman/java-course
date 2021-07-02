package com.example41.bio.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        String ip = "localhost";
        Socket socket = new Socket(ip, 3000);
        while (true) {
            try {
                // 输出流不关闭，可反复在控制台输入
                OutputStream os = socket.getOutputStream();
                // 阻塞，直到控制台输入消息
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        System.in));
                String line = br.readLine();
                os.write(line.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
