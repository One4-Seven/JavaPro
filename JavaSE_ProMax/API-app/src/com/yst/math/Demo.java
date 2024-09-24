package com.yst.math;

public class Demo {
    public static void main(String[] args) {
        // 认识基本的 Math
        System.out.println(Math.abs(-147));
        System.out.println(Math.abs(-2147483648));

        System.out.println(Math.ceil(12.34));
        System.out.println(Math.ceil(-12.34));

        System.out.println(Math.floor(13.14));
        System.out.println(Math.floor(-13.14));

        System.out.println(Math.round(13.4));
        System.out.println(Math.round(13.5));
        System.out.println(Math.round(-13.4));
        System.out.println(Math.round(-13.6));

        System.out.println(Math.max(30, 40));
        System.out.println(Math.min(30, 40));

        System.out.println(Math.pow(2, 3));
        System.out.println(Math.pow(2, -3));
        System.out.println(Math.sqrt(4));
        System.out.println(Math.cbrt(8));

        // 返回 [0, 1) 的随机数
        System.out.println(Math.random());

        // 返回 [1, 100] 都包含的随机数
        System.out.println(Math.floor(Math.random() * 100) + 1);

        // 获取水仙花数
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            int ge = i % 10;
            int shi = (i / 10) % 10;
            int bai = (i / 100) % 10;
            double sum = Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3);
            if (sum == i) {
                System.out.println("水仙花数: " + sum);
                count++;
            }
        }
        System.out.println("水仙花数总数: " + count);
    }
}
