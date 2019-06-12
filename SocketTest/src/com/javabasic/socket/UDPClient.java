package com.javabasic.socket;

import java.io.IOException;
import java.net.*;

public class UDPClient {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] buff = "Hello world".getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(buff, buff.length, address, 65001);
        socket.send(packet);


        byte[] data = new byte[100];
        DatagramPacket receivePacket = new DatagramPacket(data, data.length);
        socket.receive(receivePacket);
        String content = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println(content);
    }

}
