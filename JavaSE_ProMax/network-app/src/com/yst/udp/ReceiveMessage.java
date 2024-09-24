package com.yst.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMessage {
    public static void main(String[] args) throws IOException {
        // 结合数据
        // 创建快递公司并绑定端口
        DatagramSocket ds = new DatagramSocket(10086);

        // 接受数据容器
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        // 接受数据
        ds.receive(dp);

        // 解析数据
        byte[] data = dp.getData();
        int length = dp.getLength();
        InetAddress address = dp.getAddress();
        int port = dp.getPort();
        String hostName = address.getHostName();

        System.out.println("数据内容: " + new String(data, 0, length));
        System.out.println("数据由" + hostName + "的" + port + "端口发送");

        // 释放资源
        ds.close();
    }
}
