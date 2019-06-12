package com.javabasic.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        // 创建socket 并将socket绑定到65000端口
        ServerSocket serverSocket = new ServerSocket(65000);
        while (true) {
            // 监听65000端口 知道客户端返回连接信息后才返回
            Socket socket = serverSocket.accept();
            // 获取客户端的请求信息后，执行相关的业务逻辑
            new LengthCalculator(socket).start();
        }
    }
}
