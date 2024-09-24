package com.yst.modifer;

public class Demo {
    public static void main(String[] args) {
        // 认识基本的四个权限修饰符
        Modifer mod = new Modifer();
        System.out.println("在此类中可以调用的方法");
        System.out.println("------------------------------");
        mod.textMethod();
        System.out.println("------------------------------");

        // 在同一包下的其他类中
        System.out.println("在同一包下的其他类中可以调用的方法");
        System.out.println("------------------------------");
        mod.Method();
        mod.protectedMethod();
        mod.publicMethod();
        System.out.println("------------------------------");
    }
}
