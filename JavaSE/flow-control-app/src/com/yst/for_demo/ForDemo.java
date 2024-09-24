package com.yst.for_demo;

public class ForDemo {
    public static void main(String[] args) {
        // for 循环结构
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);

        // for 循环嵌套
        for (int i = 1; i <= 9; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(i + " x " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }

        // 循环标记,可以随意设置
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 2) {
                    // 跳过外层循环 直接结束程序
                    break outer;
                }
                System.out.println(j);
            }
            System.out.println("test");
        }
        System.out.println("finish");

    }
}
