package com.yst.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 认识理解 IO 流的基本用法
        File file = new File("IO-app\\text\\out.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        // 默认读取一个字符 返回它的 ASCII 如果没有内容则返回 -1
        int a = fileInputStream.read();
        System.out.println((char) a);

        int b = fileInputStream.read();
        System.out.println((char) b);

        int c = fileInputStream.read();
        System.out.println((char) c);

        // 利用循环读取文件所有内容 read 方法类似 集合指针中的 next 方法 读取内容返回并指向下一个位置
        int d;
        while ((d = fileInputStream.read()) != -1) {
            System.out.print((char) d);
        }
        System.out.println("\n----------");

        // 结束程序对该文件的内存占用
        fileInputStream.close();

        // 利用字节数组读取文件内容 返回读取的字节个数 数组中存放读取内容的 ASCII
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[4];
        int len;

        while ((len = fis.read(bytes)) != -1) {
            String string = new String(bytes, 0, len);
            System.out.println(string);
        }

        fis.close();
    }
}
