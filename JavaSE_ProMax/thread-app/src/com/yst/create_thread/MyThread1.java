package com.yst.create_thread;

public class MyThread1 extends Thread {
    public MyThread1() {
    }

    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // getName 获取线程名字
            System.out.println(getName() + ": @ " + (i + 1));
        }
    }
}
