package com.yst.chat_room;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        // 客户端
        Socket socket = new Socket("127.0.0.1", 10086);
        System.out.println("与服务器建立连接");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("----------南审聊天室----------");
            System.out.println("[1] 登录");
            System.out.println("[2] 注册");
            System.out.println("[3] 退出");
            System.out.println("-----------------------------");
            System.out.print("选择你的业务: ");
            String next = sc.next();

            switch (next) {
                case "1":
                    Login(socket);
                    break;
                case "2":
                    Register(socket);
                    break;
                case "3":
                    break;
                default:
                    System.out.println("逼养的看不懂?");
            }

            if ("3".equals(next)) break;
        }
    }

    // 向服务器发送注册请求
    private static void Register(Socket socket) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("用户名: ");
        String newusername = sc.next();
        System.out.print("密码: ");
        String newpassword = sc.next();
        String register = newusername + "=" + newpassword;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("register");
        bw.newLine();
        bw.flush();

        bw.write(register);
        bw.newLine();
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = br.readLine();

        System.out.println(result);
    }

    // 向服务器发送登录请求
    private static void Login(Socket socket) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("用户名: ");
        String username = sc.next();
        System.out.print("密码: ");
        String password = sc.next();
        String login = username + "=" + password;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("login");
        bw.newLine();
        bw.flush();

        bw.write(login);
        bw.newLine();
        bw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String result = br.readLine();

        switch (result) {
            case "账号或密码错误":
                System.out.println(result);
                break;

            case "登录成功":
                System.out.println(result);
                new Thread(new ClientRunnable(socket)).start();
                talkToAll(bw);
        }

    }
    private static void talkToAll(BufferedWriter bw) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("请输入您要说的话: ");
            String str = sc.nextLine();
            //把聊天内容写给服务器
            bw.write(str);
            bw.newLine();
            bw.flush();
        }
    }
}
