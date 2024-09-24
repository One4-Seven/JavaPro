package com.yst.buffered;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 了解缓冲流以及它的特有方法
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("IO-app\\text\\out.txt"));
        System.out.println(bis.read());

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("IO-app\\text\\out.txt"));
        byte[] bytes = {66, 67, 68, 69};

        bos.write(65);
        bos.write(bytes);

        BufferedReader br = new BufferedReader(new FileReader("IO-app\\text\\write.txt"));
        System.out.println(br.read());
        // readline 方法不会把换行符读入 且会返回一个字符串
        System.out.println(br.readLine());

        BufferedWriter bw = new BufferedWriter(new FileWriter("IO-app\\text\\write.txt"));
        bw.write("嘻嘻嘻");
        // 在文件中换行 可以根据不同操作系统自动切换
        bw.newLine();
        bw.write("嘻嘻嘻");

        bw.close();
        br.close();
        bos.close();
        bis.close();
    }
}
