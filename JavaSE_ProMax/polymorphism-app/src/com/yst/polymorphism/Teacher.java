package com.yst.polymorphism;

public class Teacher extends People {
    public String name = "老师";

    public void run() {
        System.out.println("老师跑得慢!");
    }

    public void speak() {
        System.out.println("教书育人,勤勤恳恳!");
    }
}
