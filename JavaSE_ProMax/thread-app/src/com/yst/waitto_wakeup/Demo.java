package com.yst.waitto_wakeup;

public class Demo {
    public static void main(String[] args) {
        // 认识简单的生产者消费者问题
        // 等待唤醒机制
        Thread t1 = new Foodie();
        Thread t2 = new Cook();

        t1.start();
        t2.start();
    }
}
