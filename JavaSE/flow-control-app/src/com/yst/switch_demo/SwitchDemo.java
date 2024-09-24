package com.yst.switch_demo;

import java.util.Scanner;

public class SwitchDemo {
    public static void main(String[] args) {
        // Switch 选择分支判断语句 不支持使用 float double long 类型的数据
        Scanner sc = new Scanner(System.in);
        System.out.println("哥们,请问今天周几?");
        String day = sc.next();

        switch (day) {
            case "周一":
                System.out.println("好好学习,天天向上");
                break;
            case "周二":
                System.out.println("看美女跳舞视频");
                break;
            case "周三":
                System.out.println("看帅哥跳舞视频");
                break;
            case "周四":
                System.out.println("疯狂星期四");
                break;
            case "周五":
                System.out.println("无畏契约,启动!");
                break;
            case "周六":
                System.out.println("原神,启动!");
                break;
            case "周末":
                System.out.println("星铁,启动!");
                break;
            default:
                System.out.println("哥们火星人吗,周几都分不清?");
        }
    }
}
