package com.yst.number_encryption;

public class NumberEncryption {
    public static void main(String[] args) {
        // 对整型数字进行加密算法
        int key = 521471;
        System.out.println("原密码: " + key);

        int newkey = encrypt(key);
        System.out.println("加密后: " + newkey);

        int oldkey = encrypt(newkey);
        System.out.println("解密后: " + oldkey);
    }

    // 加(解)密字符串
    public static int encrypt(int num) {
        // 创建整型数组
        int[] keys = split(num);

        // 加密算法
        for (int i = 0; i < keys.length; i++) {
            keys[i] = (keys[i] + 5) % 10;
        }

        // 翻转列表
        reverse(keys);

        // 返回加密后的整型
        return printarray(keys);
    }

    // 把整型转换为数组
    public static int[] split(int num) {
        int[] number = new int[6];

        number[0] = num / 100000;
        number[1] = (num / 10000) % 10;
        number[2] = (num / 1000) % 10;
        number[3] = (num / 100) % 10;
        number[4] = (num / 10) % 10;
        number[5] = num % 10;

        return number;
    }

    // 交换数组顺序
    public static void reverse(int[] number) {
        for (int i = 0, j = number.length - 1; i < j; i++, j--) {
            int temp = number[i];
            number[i] = number[j];
            number[j] = temp;
        }
    }

    // 打印列表 把列表转换为字符串
    public static int printarray(int[] num) {
        int sum = 0;
        for (int i = 0, j = num.length - 1; i < num.length; i++, j--) {
            sum += num[i] * Math.pow(10, j);
        }
        return sum;
    }
}
