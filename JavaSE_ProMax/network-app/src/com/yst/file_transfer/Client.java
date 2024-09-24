package com.yst.file_transfer;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // 把本地文件上传到服务器
        Socket socket = new Socket("127.0.0.1", 10086);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("network-app\\clientdir\\Steam.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        // 使用缓冲流需要注意关闭或者刷新缓冲流 防止数据丢失
        bos.flush();
        bis.close();

        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(br.readLine());

        socket.close();
    }
}
