package com.yst.array;

import java.util.Random;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        // 静态初始化数组
        int[] number = {1, 2, 3, 4, 5};
        System.out.println("原数组: ");
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
        System.out.println();

        // 交换数组顺序
        for (int i = 0, j = number.length - 1; i < j; i++, j--) {
            int temp = number[i];
            number[i] = number[j];
            number[j] = temp;
        }

        System.out.println("交换顺序后: ");
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
        System.out.println();

        // 随机打乱数组
        Random r = new Random();
        for (int i = 0; i < number.length; i++) {
            int index = r.nextInt(number.length);
            int temp = number[index];
            number[index] = number[i];
            number[i] = temp;
        }

        System.out.println("打乱顺序后: ");
        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i] + " ");
        }
        System.out.println();

        // 动态初始化数组
        int[] arr1 = new int[3];
        double[] arr2 = new double[3];
        boolean[] arr3 = new boolean[3];
        String[] arr4 = new String[3];

        System.out.println(arr1[2]);
        System.out.println(arr2[2]);
        System.out.println(arr3[2]);
        System.out.println(arr4[2]);

        // 引用变量的赋值
        int[] arr5 = {11, 22, 33, 44, 55};
        int[] arr6 = arr5;

        System.out.println("arr5 引用变量中存储的地址是: " + arr5);
        System.out.println("arr6 引用变量中存储的地址是: " + arr6);
        System.out.println("arr5 数组的第三个元素是: " + arr5[2]);
        System.out.println("arr6 数组的第三个元素是: " + arr6[2]);

        // 仅修改 arr5 数组的值
        arr5[2] = 99;
        System.out.println("修改后 arr5 数组的第三个元素是: " + arr5[2]);
        System.out.println("修改后 arr6 数组的第三个元素是: " + arr6[2]);

        // 空指针
        arr6 = null;

        // 遍历动态数组
        double[] score = new double[6];
        double sum = 0;
        double average = 0;
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < score.length; i++) {
            System.out.print("请给出你的分数: ");
            score[i] = sc.nextDouble();
        }

        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }

        average = sum / score.length;
        System.out.println("你的最终得分为: " + sum);
        System.out.println("你的平均得分为: " + average);
    }
}
