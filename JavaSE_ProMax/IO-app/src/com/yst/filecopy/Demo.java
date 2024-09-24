package com.yst.filecopy;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 小文件的拷贝 一个字节的拷贝 效率低
        File file = new File("D:\\Desktop\\超级无敌牛逼\\奶妈酱.jpg");
        File newfile = new File("IO-app\\text\\copy.jpg");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(newfile);

        long start1 = System.currentTimeMillis();

        int a;
        while ((a = fis.read()) != -1) {
            fos.write(a);
        }

        long end1 = System.currentTimeMillis();
        System.out.println("本次拷贝耗时: " + (end1 - start1) + "ms");

        fos.close();
        fis.close();

        // 大文件拷贝 创建指定大小的字节数组
        FileInputStream fileInputStream = new FileInputStream("E:\\Steam\\steamapps\\workshop\\content\\431960\\2609062096\\28.mp4");
        FileOutputStream fileOutputStream = new FileOutputStream("IO-app\\text\\GirlFriend.mp4");

        long start2 = System.currentTimeMillis();

        // 记录本次读取到的字节数 没有则返回-1
        int len;

        // 控制每次读取的字节数 5MB
        byte[] b = new byte[1024 * 1024 * 5];

        // 循环拷贝字节文件 利用数组提高效率
        while ((len = fileInputStream.read(b)) != -1) {
            // 每次从读取的字节数组中写入指定部分的内容
            fileOutputStream.write(b, 0, len);
        }

        long end2 = System.currentTimeMillis();
        System.out.println("本次拷贝耗时: " + (end2 - start2) + "ms");

        fileOutputStream.close();
        fileInputStream.close();
    }
}
