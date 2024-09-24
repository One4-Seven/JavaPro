package com.yst.dual_coloured_ball;

import java.util.Random;
import java.util.Scanner;

public class DualColouredBall {
    public static void main(String[] args) {
        // 模拟双色球
        int[] user_number = buyticket();
        int[] lucky_number = luckyticket();

        if (cheackticket(user_number, lucky_number)) {
            System.out.print("你购买的双色球号码: ");
            printnumber(user_number);
            System.out.print("本期双色球中奖号码: ");
            printnumber(lucky_number);
            System.out.println("逼养的,你中大奖了!");
        } else {
            System.out.print("你购买的双色球号码: ");
            printnumber(user_number);
            System.out.print("本期双色球中奖号码: ");
            printnumber(lucky_number);
            System.out.println("可惜了兄弟,差点!");
        }
    }

    public static int[] buyticket() {
        int[] ticket = new int[7];
        Scanner sc = new Scanner(System.in);

        // 用户选择红球号码
        for (int i = 0; i < 6; i++) {
            while(true) {
                System.out.println("请给出第" + (i + 1) + "个红球的号码(1-33,不得重复!)");
                int number = sc.nextInt();
                // 判断用户选择是否合法
                if (number < 1 || number > 33) {
                    System.out.println("哥们看不懂范围?");
                } else if (exit(number, ticket)) {
                    System.out.println("重复了哦宝贝~");
                } else {
                    ticket[i] = number;
                    break;
                }
            }
        }

        // 用户选择蓝球号码
        while(true) {
            System.out.println("请给出蓝球的号码(1-16)");
            int number = sc.nextInt();
            // 判断用户选择是否合法
            if (number < 1 || number > 16) {
                System.out.println("哥们看不懂范围?");
            } else {
                ticket[6] = number;
                break;
            }
        }

        return ticket;
    }

    public static boolean exit(int number, int[] numbers) {
        for (int j : numbers) {
            if (number == j) {
                return true;
            }
        }
        return false;
    }

    public static int[] luckyticket() {
        int[] ticket = new int[7];
        Random r = new Random();
        // 随机生成红球的中奖号码
        for (int i = 0; i < 6; i++) {
            while(true) {
                int number = r.nextInt(33) + 1;
                if(!exit(number, ticket)) {
                    ticket[i] = number;
                    break;
                }
            }
        }

        // 随机生成蓝球的中奖号码
        ticket[6] = r.nextInt(16) + 1;
        return ticket;
    }

    public static boolean cheackticket(int[] a, int[] b) {
        for (int i = 0; i < 7; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printnumber(int[] number) {
        System.out.print('[');
        for (int i = 0; i < 7; i++) {
            System.out.print(i == 6 ? number[i] : number[i] + ", ");
        }
        System.out.print("]\n");
    }
}
