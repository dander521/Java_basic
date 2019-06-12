package com.javabasic.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LengthCalculator extends Thread {

    private Socket socket;

    public LengthCalculator(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 获取socket的输出流
            OutputStream os = socket.getOutputStream();
            // 获取socket的输入流
            InputStream is = socket.getInputStream();
            // 获取读取数组的长度
            int ch = 0;
            // 用来读取输入的内容，存储byte数组
            byte[] buff = new byte[1024];
            ch = is.read(buff);
            // 将buff转换成字符串
            String content = new String(buff, 0, ch);
            System.out.println(content);
            // 往输出流写入获取字符串的长度 并转换为byte数组
            os.write(String.valueOf(content.length()).getBytes());
            is.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
