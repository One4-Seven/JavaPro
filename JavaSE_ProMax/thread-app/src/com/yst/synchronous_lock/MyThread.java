package com.yst.synchronous_lock;

public class MyThread extends Thread {
    static int count = 0;

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        // 同步代码块 有线程在运行时其他线程无法进入
        while (true) {
            synchronized (MyThread.class) {
                if (count < 1000) {
                    count++;
                    System.out.println(getName() + "卖出了第" + count + "张票");
                } else {
                    break;
                }
            }
        }
    }
}
