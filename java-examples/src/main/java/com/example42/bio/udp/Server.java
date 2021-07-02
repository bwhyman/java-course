package com.example42.bio.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        // 监听本地端口
        DatagramSocket socket = new DatagramSocket(4567);
        byte[] data = new byte[1024];

        while (true) {
            DatagramPacket packet = new DatagramPacket(data, data.length);
            // 阻塞，直到接收到消息报包
            socket.receive(packet);
            String result = new String(packet.getData(), packet.getOffset(), packet.getLength());
            System.out.println("消息：" + result);
            System.out.println(packet.getAddress().getHostAddress());
            System.out.println(packet.getPort());
        }
    }
}
