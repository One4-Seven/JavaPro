package com.yst.static_demo;

public class Test {
    // 类变量
    static int number;
    static String school;

    // 成员变量
    String name;

    public Test() {
        System.out.println("无参构造器执行!");
        number++;
    }

    public Test(String name) {
        System.out.println("有参构造器执行!");
        this.name = name;
        number++;
    }

    // 类方法
    public static void speakhello() {
        System.out.println("Hello! Nice to meet you!");
    }

    // 成员方法
    public void personal() {
        System.out.println("大家好,我是新同学" + name);
    }

    // 静态代码块 类加载时自动执行 只会执行一次 可以用于对复杂的类变量初始化
    static {
        System.out.println("Text 类已在内存中加载完毕!");
        school = "家里蹲大学";
    }

    // 实例代码块 每次创建实例时都会执行 在执行构造方法之前执行 即遇到 new 关键字时就执行
    {
        System.out.println("有新的实例被创建,实例地址: " + this);
    }


}
