package com.yst.filereader;

import java.io.FileReader;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 字符流读入 FileReader 返回读取字符在对印字符集中的数字
        // 不存在则返回-1
        FileReader fileReader = new FileReader("IO-app\\text\\write.txt");

        int a;
        while ((a = fileReader.read()) != -1) {
            System.out.println((char) a);
        }

        fileReader.close();

        // 利用字符数组读取文件内容 返回读取的字符个数 数组中存放读取内容的
        FileReader fr = new FileReader("IO-app\\text\\write.txt");

        int len;
        char[] chars = new char[3];
        while ((len = fr.read(chars)) != -1) {
            String s = new String(chars, 0, len);
            System.out.println(s);
        }

        fr.close();
    }
}
