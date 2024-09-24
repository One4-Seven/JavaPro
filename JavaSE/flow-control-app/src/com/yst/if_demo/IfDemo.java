package com.yst.if_demo;

public class IfDemo {
    public static void main(String[] args) {
        // if 条件分支判断语句
        double temperature = 36.5;
        if(temperature > 36.9) {
            System.out.println("体温过高!");
        } else if(temperature < 36.3) {
            System.out.println("体温过低!");
        } else {
            System.out.println("体温正常!");
        }

        int score = 101;
        if(score >= 0 && score < 60) {
            System.out.println("不合格!");
        } else if(score >= 60 && score < 90) {
            System.out.println("良好!");
        } else if(score >= 90 && score < 100) {
            System.out.println("优秀!");
        } else if(score == 100) {
            System.out.println("ACE!");
        } else {
            System.out.println("你这分数不对啊?");
        }
    }
}
