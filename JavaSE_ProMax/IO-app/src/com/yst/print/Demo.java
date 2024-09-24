package com.yst.print;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 认识字节和字符打印流的构造和基本方法
        // 字节打印流 只能用 FileOutputStream 创建
        PrintStream ps = new PrintStream(new FileOutputStream("IO-app\\text\\print.txt"), false, "UTF-8");

        ps.println(888);
        ps.print(999);
        ps.printf("%n%s是大傻逼比%n", "张升源");

        ps.close();

        // 字符打印流 FileOutputStream FileWriter 都可以创建
        PrintWriter pw = new PrintWriter(new FileWriter("IO-app\\text\\print.txt", true), true);

        pw.println(777);
        pw.print("哈哈哈哈哈哈\n");
        pw.printf("%d", 100000);

        pw.close();
    }
}
