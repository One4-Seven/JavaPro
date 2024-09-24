package com.yst.chat_room;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class ServerRunnable implements Runnable {
    Socket socket;
    Properties prop;
    public ServerRunnable(Socket socket, Properties prop) {
        this.prop = prop;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String s = br.readLine();
                if ("login".equals(s)) login(br);
                else if ("register".equals(s)) register(br);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void register(BufferedReader br) throws IOException {
        String string = br.readLine();
        String username = string.split("=")[0];
        String password = string.split("=")[1];

        if (username.isEmpty() || password.isEmpty()) {
            writeMessageToClient("用户名密码为空");
        }
        if (prop.containsKey(username)) {
            writeMessageToClient("账号已存在");
        } else {
            writeMessageToClient("注册成功");
            BufferedWriter bw = new BufferedWriter(new FileWriter("network-app\\users\\user.txt", true));
            bw.newLine();
            bw.write(string);
            bw.close();

            FileInputStream fis = new FileInputStream("network-app\\users\\user.txt");
            prop.load(fis);
            fis.close();
        }
    }

    private void login(BufferedReader br) throws IOException {
        String string = br.readLine();
        String username = string.split("=")[0];
        String password = string.split("=")[1];

        if (prop.containsKey(username)) {
            if (password.equals(prop.get(username))) {
                writeMessageToClient("登录成功");
                Server.sockets.add(socket);
                talkToAll(br, username);
            }
        } else {
            writeMessageToClient("账号或密码错误");
        }
    }

    private void talkToAll(BufferedReader br, String username) throws IOException {
        while (true) {
            String message = br.readLine();
            System.out.println(username + ": " + message);

            // 群发
            for (Socket s : Server.sockets) {
                //s依次表示每一个客户端的连接对象
                writeMessageToClient(s, "来自聊天室成员 —— " + username + ": " + message);
            }
        }
    }

    // 给当前发送来数据的客户端恢复数据
    public void writeMessageToClient(String message) throws IOException {
        //获取输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(message);
        bw.newLine();
        bw.flush();
    }

    // 给指定客户端发送数据
    public void writeMessageToClient(Socket socket, String message) throws IOException {
        //获取输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(message);
        bw.newLine();
        bw.flush();
    }
}
