package com.yst.synchronous_lock;

public class Demo {
    public static void main(String[] args) {
        // 认识同步代码块
        MyThread t1 = new MyThread("一号窗口");
        MyThread t2 = new MyThread("二号窗口");
        MyThread t3 = new MyThread("三号窗口");

        t1.start();
        t2.start();
        t3.start();
    }
}
