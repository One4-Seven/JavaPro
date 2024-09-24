package com.yst.operator;

public class Operator {
    public static void main(String[] args) {
        // 整型除法
        int a = 10;
        int b = 2;

        System.out.println(a % b);
        System.out.println(a / b);
        System.out.println(10.0 / b);

        // 能算就算 不能算就在一起
        int number = 5;
        String item = "Yang Si Ting";

        System.out.println(item + number);
        System.out.println(10 + number);
        System.out.println(item + number + 'a');
        System.out.println(number + 'a' + item);

        // 关系运算符
        System.out.println(a > b);
        System.out.println(a == b);
        System.out.println(a != b);

        // 逻辑运算符
        System.out.println(a > 2 & b > 1);
        System.out.println(a < 2 | b > 1);
        System.out.println(!(a > 2 & b > 1));
        // 异或运算 相同为False 不同为True
        System.out.println(a > 2 ^ b > 1);

        // 三元运算符
        double score = 88.5;
        String ressult = score >= 60 ? "成绩合格" : "成绩不合格";
        System.out.println(ressult);

        int max = a > b ? a : b;
        System.out.println(max);
    }
}
