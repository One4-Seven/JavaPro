package com.yst.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 认识简单的 TCP 协议下的发送数据
        // 创建快递公司 用户发送数据
        // 需要确定连接就发送信息
        // 创建客户端
        Socket socket = new Socket("127.0.0.1", 10086);

        // 获取输出流
        OutputStream ops = socket.getOutputStream();

        // 发送数据
        ops.write("message".getBytes());

        // 释放资源
        ops.close();
        socket.close();
    }
}
