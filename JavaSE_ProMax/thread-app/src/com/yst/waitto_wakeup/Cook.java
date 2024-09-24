package com.yst.waitto_wakeup;

public class Cook extends Thread {
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    if (Desk.flag == 1) {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("大厨做了一个蛋糕!");
                        Desk.flag = 1;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
