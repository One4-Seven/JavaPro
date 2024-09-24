package com.yst.biginteger;

import java.math.BigInteger;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        // 认识 BigInteger 类的构造和基本成员方法
        // 创建 BigInteger 对象
        Random r = new Random();

        // 获取随机大整数 返回值范围: [0, pow(2, n) - 1]
        BigInteger bd1 = new BigInteger(4, r);
        System.out.println(bd1);

        // 指定大整数 接收字符串
        BigInteger bd2 = new BigInteger("10");
        System.out.println(bd2);

        // 获取指定进制的数
        BigInteger bd3 = new BigInteger("100", 2);
        System.out.println(bd3);

        // 静态方法获取大整数 范围为 long
        // [-16, 16] 会被默认加载 返回的是同一个对象 处理数据速度快
        BigInteger bd4 = BigInteger.valueOf(10);
        BigInteger bd5 = BigInteger.valueOf(10);

        if (bd4 == bd5) System.out.println("bd4 和 bd5 的地址相同!");

        // 使用 BigInteger 类的成员方法
        // 加法
        BigInteger bd6 = bd2.add(bd3);
        System.out.println(bd6);

        // 减法
        BigInteger bd7 = bd2.subtract(bd3);
        System.out.println(bd7);

        // 乘法
        BigInteger bd8 = bd2.multiply(bd3);
        System.out.println(bd8);

        // 除法 返回商
        BigInteger bd9 = bd2.divide(bd3);
        System.out.println(bd9);

        // 除法 返回一个 BigInteger 数组 包含商和余数
        BigInteger[] bd10 = bd2.divideAndRemainder(bd3);
        System.out.println(bd10[0]);
        System.out.println(bd10[1]);

        // 比较是否相同
        if (bd2.equals(bd4)) {
            System.out.println("bd2 和 bd4 存储的内容相同");
        } else {
            System.out.println("bd2 和 bd4 存储的内容不同");
        }

        // 次幂
        BigInteger bd11 = bd2.pow(3);
        System.out.println(bd11);

        // 获取较大值 直接返回较大的 BigInteger 对象
        BigInteger bd12 = bd2.max(bd3);
        if (bd12 == bd2) System.out.println("bd12 和 bd2 的地址相同!");
        if (bd12 == bd3) System.out.println("bd12 和 bd3 的地址相同!");

        // 获取较小值 直接返回较小的 BigInteger 对象
        BigInteger bd13 = bd2.min(bd3);
        if (bd13 == bd2) System.out.println("bd13 和 bd2 的地址相同!");
        if (bd13 == bd3) System.out.println("bd13 和 bd3 的地址相同!");

        // 转换为指定类型返回
        int num1 = bd2.intValue();
        System.out.println(num1);

        double num2 = bd3.doubleValue();
        System.out.println(num2);


    }
}
