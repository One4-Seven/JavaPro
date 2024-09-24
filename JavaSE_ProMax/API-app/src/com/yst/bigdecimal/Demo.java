package com.yst.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Demo {
    public static void main(String[] args) {
        // 认识 BigDecimal 类的构造和基本成员方法
        // 创建 BigDecimal 对象 传递字符串 一般处理较大小数
        // 把字符串转为 byte 类型的数组 依次存储其阿斯克码表中的值
        BigDecimal bd1 = new BigDecimal("0.1");
        System.out.println(bd1);

        BigDecimal bd2 = new BigDecimal("0.9");
        System.out.println(bd2);

        // 静态方法获取小数 范围小于 double 时建议使用此方法
        // [0, 10] 会被默认加载 返回的是同一个对象 处理数据速度快
        // 默认传入数据为 long 类型 如果传入的数为 double 会自动使用构造方法来创建新的 BigDecimal 对象
        BigDecimal bd3 = BigDecimal.valueOf(10);
        BigDecimal bd4 = BigDecimal.valueOf(10);

        if (bd3 == bd4) System.out.println("bd3 和 bd4 的地址相同!");

        // 使用 BigDecimal 类的成员方法
        // 加法
        BigDecimal bd5 = bd1.add(bd2);
        System.out.println(bd5);

        // 减法
        BigDecimal bd6 = bd2.subtract(bd1);
        System.out.println(bd6);

        // 乘法
        BigDecimal bd7 = bd2.multiply(bd3);
        System.out.println(bd7);

        // 除法 返回商
        // 使用单参数 如果除不尽则会报错
        // 采用三参数避免报错 (除数, 保留小数位数, 舍入模式)
        BigDecimal bd8 = bd2.divide(bd1, 2, RoundingMode.HALF_UP);
        System.out.println(bd8);

    }
}
