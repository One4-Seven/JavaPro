package com.yst.chat_room;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;

public class Server {
    static ArrayList<Socket> sockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);

        // 把本地文件中正确的用户名和密码获取到
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("network-app\\users\\user.txt");
        prop.load(fis);
        fis.close();

        while (true) {
            Socket socket = ss.accept();
            System.out.println("有客户端来链接");
            new Thread(new ServerRunnable(socket, prop)).start();
        }
    }
}
