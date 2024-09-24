package com.yst.type_conversion;

public class TypeConversion {
    public static void main(String[] args) {
        // 隐式(自动)类型转换
        byte a = 127;
        int b = a;
        System.out.println(b);

        char c = 'A';
        int d = c;
        System.out.println(d);

        int f = 100;
        double g = f;
        System.out.println(g);

        // byte short char 在表达式运算中会自动转换为 int
        short h = 147;
        char i = 'B';
        int j = h + i;
        System.out.println(j);

        // 强制类型转换
        int k = 99;
        byte m = (byte)k;
        System.out.println(m);

        // 溢出
        int n = 1500;
        byte p = (byte)n;
        System.out.println(p);

        double r = 666.666;
        int s = (int)r;
        System.out.println(s);
    }
}
