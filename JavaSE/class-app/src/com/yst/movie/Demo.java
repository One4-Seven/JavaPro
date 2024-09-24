package com.yst.movie;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // 模拟电影信息查询系统(JavaBean 结构)
        Movie m1 = new Movie(1, "泰坦尼克号", 48, 9.5, "James Cameron");
        Movie m2 = new Movie(2, "周处除三害", 68, 9.2, "黄精甫");
        Movie m3 = new Movie(3, "白雪公主", 58, 9.0, "塔西姆·辛");
        Movie m4 = new Movie(4, "飞驰人生2", 68, 9.3, "韩寒");
        Movie m5 = new Movie(5, "Black Mirror", 88, 9.9, "大卫·斯雷德");

        Scanner sc = new Scanner(System.in);
        Movie[] movies = {m1, m2, m3, m4, m5};
        MovieOperator mo = new MovieOperator(movies);

        System.out.println("------------南 审 影 院------------");
        mo.hotMoive();
        System.out.println("------------当 前 热 映------------");

        System.out.println("输入[1]查询所有电影信息!");
        System.out.println("输入[2]查询指定电影信息!");
        System.out.println("输入[3]退出系统!");

        while (true) {
            System.out.print("查询方式: ");
            int flag = sc.nextInt();
            // 查询所有信息
            if (flag == 1) {
                mo.showAllInfo();
            }
            // 查询指定信息
            else if (flag == 2) {
                System.out.print("请输入你要查询的电影编号: ");
                int id = sc.nextInt();
                mo.searchInfo(id);
            }
            // 退出系统
            else if (flag == 3) {
                break;
            }
            // 用户输入错误
            else {
                System.out.println("哥们,上面的提示看不懂?");
            }
        }
    }
}
