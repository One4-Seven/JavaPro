package com.yst.system;

public class Demo {
    public static void main(String[] args) {
        // 简单认识 System
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = new int[10];

        // 数组拷贝 (数据源, 数据源起始位置, 目的源, 目的源起始位置, 拷贝元素个数)
        System.arraycopy(arr1, 0, arr2, 0, 10);
        for (int j : arr2) {
            if (j != 10) {
                System.out.print(j + ", ");
            } else {
                System.out.println(j);
            }
        }

        // 记录系统时间 单位是毫秒
        long start1 = System.currentTimeMillis();

        // 寻找素数 check1
        for (int i = 1; i <= 100000; i++) {
            if (check1(i)) System.out.print("");
        }

        long end1 = System.currentTimeMillis();
        System.out.println("check1 程序运行总时间: " + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();

        // 寻找素数 check2
        for (int i = 1; i <= 100000; i++) {
            if (check2(i)) System.out.print("");
        }

        long end2 = System.currentTimeMillis();
        System.out.println("check2 程序运行总时间: " + (end2 - start2) + "ms");

        System.out.println("总程序运行总时间: " + (end2 - start1) + "ms");
    }

    public static boolean check1(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean check2(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
