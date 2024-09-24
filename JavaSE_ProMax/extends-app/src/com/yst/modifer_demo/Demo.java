package com.yst.modifer_demo;

import com.yst.modifer.Modifer;

public class Demo {
    public static void main(String[] args) {
        // 认识基本的四个权限修饰符
        ModiferSon mod = new ModiferSon();
        System.out.println("在任意包的子类中可以调用的方法");
        System.out.println("------------------------------");
        mod.text();
        System.out.println("------------------------------");

        // 任意包下的任意类中
        System.out.println("在任意包下的任意类中可以调用的方法");
        System.out.println("------------------------------");
        mod.publicMethod();
        System.out.println("------------------------------");
    }
}
