package com.yst.create_thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 简单认识多线程
        // 创建线程的三种方法 和 Thread 类的一些基本方法
        // 直接继承 Thread 类
        Thread t1 = new MyThread1("线程一");
        System.out.println("线程一默认优先级: " + t1.getPriority());

        // 实现 Runnable 接口
        MyThread2 mt2 = new MyThread2();
        Thread t2 = new Thread(mt2);
        t2.setName("线程二");
        System.out.println("线程二默认优先级: " + t2.getPriority());

        // 实现 Callable<> 接口 可以有返回值 结果由 FutureTask<> 保存
        MyThread3 mt3 = new MyThread3();
        FutureTask<Integer> ft = new FutureTask<>(mt3);
        Thread t3 = new Thread(ft);
        t3.setName("线程三");
        System.out.println("线程三默认优先级: " + t3.getPriority());

        System.out.println("main方法线程默认优先级: " + Thread.currentThread().getPriority());

        // 获取当前运行的线程 main 方法线程并修改线程名字
        // 默认在程序运行时 自动开启 main 方法在内的多条线程
        Thread.currentThread().setName("我是 main 方法线程");
        System.out.println(Thread.currentThread().getName());

        // 运行线程
        t1.start();
        t2.start();
        t3.start();

        // 获取运行结果
        System.out.println(ft.get());

        // 守护(备胎)线程
        // 当其他的所有非守护线程结束后会自动结束
        Thread t4 = new MyThread1("备胎线程");

        MyThread2 myThread2 = new MyThread2();
        Thread t5 = new Thread (myThread2, "女神线程");

        t4.setDaemon(true);

        t4.start();
        t5.start();
    }
}
