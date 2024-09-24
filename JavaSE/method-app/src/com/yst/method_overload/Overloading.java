package com.yst.method_overload;

public class Overloading {
    public static void main(String[] args) {
        // 掌握方法的重载 方法名相同 形参列表不同
        fire();
        fire("米国");
        fire("尼加拉瓜", 3);
    }

    public static void fire() {
        System.out.println("给小日子发射1枚大宝贝!");
    }

    public static void fire(String country) {
        System.out.println("给" + country + "发射1枚大宝贝!");
    }

    public static void fire(String country, int number) {
        System.out.println("给" + country + "发射" + number + "枚大宝贝!");
    }
}
