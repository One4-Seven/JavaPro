package com.yst.file_transfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws IOException {
        // 接收数据写入到本地 并返回接收数据
        ServerSocket ss = new ServerSocket(10086);

        Socket socket = ss.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

        UUID uuid = UUID.randomUUID();
        String string = uuid.toString().replaceAll("-", "");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("network-app\\serverdir\\" + string + ".jpg"));

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bos.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String s = "无双,万军取首!";
        bw.write(s);
        bw.flush();

        socket.close();
        ss.close();
    }
}
