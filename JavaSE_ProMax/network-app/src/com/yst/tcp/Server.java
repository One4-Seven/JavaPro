package com.yst.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // 认识简单的 TCP 协议下的发送数据
        // 创建快递公司 用户发送数据
        // 需要确定连接就发送信息
        // 创建服务器 绑定服务器端口
        // 可以在浏览器输入 127.0.0.1:10086 给服务器发送数据 B/S架构
        ServerSocket ss = new ServerSocket(10086);

        // 监听客户端的链接
        Socket accept = ss.accept();

        // 获取输入流
        InputStream ips = accept.getInputStream();
        int a;
        while ((a = ips.read()) != -1) {
            System.out.print((char) a);
        }

        // 释放资源
        accept.close();
        ss.close();
    }
}
