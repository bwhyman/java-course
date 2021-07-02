package com.example42.bio.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String ip = "localhost";
        DatagramSocket socket = new DatagramSocket(4568);
        InetAddress serverAddress = InetAddress.getByName(ip);

        Scanner scan = new Scanner(System.in);
        while (true) {
            if (scan.hasNextLine()) {
                String str = scan.nextLine();
                DatagramPacket packet = new DatagramPacket(
                        str.getBytes(),
                        str.getBytes().length,
                        serverAddress,
                        4567);
                socket.send(packet);
            }
        }

    }

}

