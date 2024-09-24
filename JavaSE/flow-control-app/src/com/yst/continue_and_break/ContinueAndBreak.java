package com.yst.continue_and_break;

import java.util.Random;
import java.util.Scanner;

public class ContinueAndBreak {
    public static void main(String[] args) {
        // 随机数生成 关键字 continue break 的使用
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int luckynumber = 0;
        luckynumber = r.nextInt(1, 101);

        System.out.println("猜测一个1-100间的数字哦!");
        while (true) {
            System.out.print("请给出你的选择: ");
            int guessnumber = sc.nextInt();
            if (guessnumber > luckynumber) {
                System.out.println("猜大了哦宝贝~");
            } else if (guessnumber < luckynumber) {
                System.out.println("太小了哥们,行不行啊?");
            } else {
                System.out.println("牛逼啊,这都蒙的到!");
                break;
            }
        }

        System.out.println("最终答案就是" + luckynumber + "哦!");
    }
}
