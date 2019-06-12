package com.javabasic.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    public static void main(String[] args) throws IOException {
        // 服务端接受客户端发送的数据报
        DatagramSocket datagramSocket = new DatagramSocket(65001); // 监听端口号
        byte[] buff = new byte[100]; // 存储从客户端接收到的内容
        DatagramPacket packet = new DatagramPacket(buff, buff.length);
        // 接受客户端发送过来的内容 并将内容封装进 DatagramPacket
        datagramSocket.receive(packet);

        byte[] data = packet.getData();
        String content = new String(data, 0, packet.getLength());
        System.out.println(content);

        // 将要发送的内容转换为二进制
        byte[] sendedContent = String.valueOf(content.length()).getBytes();
        // 从packet 对象获取数据来源的地址 和 端口
        DatagramPacket packetToClient = new DatagramPacket(sendedContent, sendedContent.length, packet.getAddress(), packet.getPort());
        datagramSocket.send(packetToClient);
    }
}
