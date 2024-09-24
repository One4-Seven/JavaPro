package com.yst.static_demo;

import java.util.Scanner;

public class StaticDemo {
    public static void main(String[] args) {
        // 认识修饰词 static (静态)
        // static 修饰的成员变量称为类变量 一般使用 类名.类变量(className.variableName) 来访问
        // 创建新的实例时 所有实例公用一个类变量
        // 设置类变量
        System.out.println(Test.school);
        Test.school = "南京审计大学";

        Test t1 = new Test("张升源");
        t1.school = "上海复旦大学";

        Test t2 = new Test("黄海冰");
        t2.school = "苏州大学";

        // 访问类变量和成员变量
        System.out.println(t1.name);
        System.out.println(t1.school);
        System.out.println(t2.name);
        System.out.println(t2.school);

        Test t3 = new Test();
        t3.name = "申恒旭";

        System.out.println("当前有" + Test.number + "个实例对象");

        // 认识类方法和成员方法的区别和基本使用
        // 调用类方法 一般使用 类名.类方法(className.methodName) 来访问
        // 类方法中不可以访问成员变量 只能访问类变量 且不可使用 this 关键字
        Test.speakhello();
        t3.speakhello();

        // 调用实例方法
        // 实例方法中可以访问类变量和成员变量
        t2.personal();
        t3.personal();

        // 认识了解单例类的创建和基本用法
        // 饿汉式单例
        HungrySingle hs1 = HungrySingle.getHungrySingle();
        HungrySingle hs2 = HungrySingle.getHungrySingle();
        System.out.println("s1的地址: " + hs1);
        System.out.println("s2的地址: " + hs2);

        // 懒汉式单例
        LazySingle ls1 = LazySingle.getLazySingle();
        LazySingle ls2 = LazySingle.getLazySingle();
        System.out.println("ls1的地址: " + ls1);
        System.out.println("ls2的地址: " + ls2);

        // 实用工具类来优化代码 增加可读性
        Scanner sc = new Scanner(System.in);
        System.out.print("请问要生成多少位的随机验证码? ");
        int number = sc.nextInt();
        System.out.println("您的" + number + "位随机验证码: " + Util.createcode(number));

    }
}
