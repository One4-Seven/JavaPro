package com.yst.prime_numbers;

public class PrimeNumbers {
    public static void main(String[] args) {
        int count = 0;

        // 为外部循环设置标签
        OUT:
        for (int i = 100; i < 201; i++) {
            for (int j = 2; j < i / 2; j++) {
                if(i % j == 0) {
                    // 执行到此后 continue 操作会作用于外部循环
                    continue OUT;
                }
            }
            count++;
            System.out.println(i);
        }

        System.out.println("100-200之间的素数个数为: " + count);
    }
}
