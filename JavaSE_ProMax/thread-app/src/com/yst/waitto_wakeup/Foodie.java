package com.yst.waitto_wakeup;

public class Foodie extends Thread{
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    if (Desk.flag == 0) {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        Desk.count--;
                        System.out.println("吃货还可以吃" + Desk.count + "块蛋糕!");
                        Desk.lock.notifyAll();
                        Desk.flag = 0;
                    }
                }
            }
        }
    }
}
