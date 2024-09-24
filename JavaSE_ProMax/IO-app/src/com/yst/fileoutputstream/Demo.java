package com.yst.fileoutputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 认识理解 IO 流的基本用法
        // IO 流分为字节流和字符流 字符流只能操作纯文本文件
        // OutputStream InputStream 属于字节流 Reader Writer 属于字符流
        // 字节流参照的是 ASCII 每次默认读取一个字节 汉字最少要两个字节 所以会出现乱码
        // 字符流字节流又分为输入输出 各自有自己的实现类来完成
        File file = new File("IO-app\\text\\out.txt");

        // 默认是否允许续写为 false 每次写入会清空原有内容 设置为 true 可以续写内容
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        // 写入的是 ASCII 中的对应字符
        fileOutputStream.write(65);

        // 写入多个字符
        fileOutputStream.write(new byte[]{65, 66, 67, 68});

        // 写指定个字符 额外给出起始索引和写入个数
        fileOutputStream.write(new byte[]{97, 98, 99, 100, 101}, 1, 3);

        // 利用 getBytes 获取指定字符串的字节数组再传递给 write 进行写入操作
        String string = "\r\nhahaha\r\nhahaha";
        byte[] bytes = string.getBytes();
        fileOutputStream.write(bytes);

        // 结束程序对该文件的内存占用
        fileOutputStream.close();
    }
}
