package com.yst.number;

public class Number {
    public static void main(String[] args) {
        // 变量名使用
        int number = 147;
        System.out.println(number);
        number = 520;
        System.out.println(number);
        {
            int low = 10;
            int high = 100;
            int sum = low + high;
            System.out.println(sum);
        }
        int sum = number + 10;
        double count = 13.14;
        double result = sum + count;
        System.out.println(result);
    }
}
