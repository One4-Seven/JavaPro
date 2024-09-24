package com.yst.login_demo;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        // 模拟登录系统
        Scanner sc =new Scanner(System.in);
        boolean flag = false;
        System.out.println("------------登 录 系 统------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("用户名: ");
            String userid = sc.next();
            System.out.print("密码: ");
            String password = sc.next();
            // 检查用户输入是否正确
            if (check(userid, password)) {
                System.out.println("登录成功!");
                flag = true;
                System.out.println("---------------------------------");
                break;
            } else {
                System.out.println("用户名或密码错误,请检查输入!");
                System.out.println("---------------------------------");
            }
        }

        if (!flag) {
            System.out.println("密码错误超过三次,系统自动退出!");
            System.out.println("---------------------------------");
        }
    }

    public static boolean check(String userid, String password) {
       String userId = "yangsiting";
       String passWord = "521471";
       return userId.equals(userid) && passWord.equals(password);
    }
}
