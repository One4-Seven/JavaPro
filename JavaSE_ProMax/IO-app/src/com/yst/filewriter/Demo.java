package com.yst.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 认识 FileWriter 字符流的写入方法
        // 默认续写为 false 会直接清空文件内容
        FileWriter fw = new FileWriter("IO-app//text//write.txt", true);

        // 写入一个字符 '我'
        fw.write(25105);

        // 写入一个字符串
        String s = "我是一个大脑残";
        fw.write(s);

        // 写入字符串的一部分
        fw.write(s, 5, 2);

        // 写入一个字符数组
        char[] chars = {'我', '是', '智', '障'};
        fw.write(chars);

        // 写入一个字符数组的一部分
        fw.write(chars, 2, 2);

        // 结束程序对该文件的内存占用
        fw.close();
    }
}
