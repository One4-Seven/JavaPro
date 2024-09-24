package com.yst.scanner;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        // 创建键盘扫描器对象获取用户输入
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入你的姓名: ");
        String name = sc.next();

        System.out.print("请输入你的年龄: ");
        int age = sc.nextInt();

        String happybirthday = "祝您" + age + "岁生日快乐!";
        System.out.println("亲爱的" + name + '!' + happybirthday);
    }
}
