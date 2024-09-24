package com.yst.encoding;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 简单的编码和解码规则 认识简单的字符集
        // GBK 国标字符集 汉字两个字符 Unicode 国际字符集 汉字三个字符
        // Unicode 国际字符集 提供 UTF-8 UTF-16 等编码方式
        String string = "love杨";

        // 默认编码 UTF-8
        byte[] bytes1 = string.getBytes();
        System.out.println(Arrays.toString(bytes1));

        // 默认解码 UTF-8
        String result1 = new String(bytes1);
        System.out.println(result1);

        // 采用 GBK 编码
        byte[] bytes2 = string.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2));

        // 采用 GBK 解码
        String result2 = new String(bytes2, "GBK");
        System.out.println(result2);

        // 用国标解码 UTF-8
        String result3 = new String(bytes1, "GBK");
        System.out.println(result3);

        // 使用指定格式读取文件
        FileReader fr = new FileReader("IO-app\\text\\GBK.txt", Charset.forName("GBK"));
        FileWriter fw = new FileWriter("IO-app\\text\\UTF-8.txt",Charset.forName("UTF-8"));

        int a;
        while ((a = fr.read()) != -1) {
            System.out.print((char) a);
            fw.write(a);
        }

        fw.close();
        fr.close();
    }
}
