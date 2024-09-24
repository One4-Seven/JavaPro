package com.yst.method;

public class Method {
    public static void main(String[] args) {
        // 学会方法的定义 格式: 方法的修饰词 返回值类型 方法名(形参列表)
        // 基本类型参数传递
        int a = 1;
        int b = 2;
        System.out.printf("%d + %d = %d%n", a, b, add(a, b));

        speak();

        int sum = sum(10);
        System.out.println("1-10求和的结果是: " + sum);

        // 引用类型参数传递
        int[] arrs = {1, 2, 3, 4, 5};
        System.out.println("数组中的第一个值为: " + arrs[0]);
        change(arrs);
        System.out.println("修改后数组中的第一个值为: " + arrs[0]);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static void speak() {
        System.out.println("我叫景波,我是傻逼!");
    }

    public static int sum(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum;
    }

    public static void change(int[] arrs) {
        arrs[0] = 147;
    }
}
