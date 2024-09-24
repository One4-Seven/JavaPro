package com.yst.udp;

import java.io.IOException;
import java.net.*;

public class SendMessage {
    public static void main(String[] args) throws IOException {
        // 认识简单的 UDP 协议下的发送数据
        // 创建快递公司 用户发送数据
        // 无需确定连接就发送信息
        DatagramSocket ds = new DatagramSocket();

        // 处理数据
        String string = "我是萨哈比张升源";
        byte[] bytes = string.getBytes();
        InetAddress address = InetAddress.getByName("VENUS");
        int port = 10086;

        // 打包数据
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

        // 发送数据
        ds.send(dp);

        // 释放资源
        ds.close();
    }
}
