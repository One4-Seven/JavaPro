package com.yst.polymorphism;

public class Student extends People {
    public String name = "学生";

    public void run() {
        System.out.println("学生跑得快!");
    }
    public void speak() {
        System.out.println("好好学习,天天向上!");
    }
}
