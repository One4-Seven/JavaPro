package com.yst.try_catch;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // try catch 捕捉异常
        // try 中的语句先执行 出现异常后在 catch 语句块中寻找相应的异常 执行后面的语句
        // try 中报错的语句后面的语句将不会执行 如果没有相应的异常 则会执行控制台默认处理方式
        Scanner sc = new Scanner(System.in);
        int[] numbers1 = {1, 2, 3, 4, 5, 6};
        int[] numbers2 = null;

        System.out.print("给我第一个数字: ");
        double a = sc.nextDouble();
        System.out.print("给我第二个数字: ");

        try {
            double b = getNumber();
            System.out.println(a + " / " + b + " = " + a / b);
        } catch (ArithmeticException exception) {
            System.out.println("逼养的除以零是吧!");
        } catch (Exception exception) {
            System.out.println("代码都写不明白?");
        }

        try {
            System.out.println("数组的第十个数: " + numbers1[9]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("数组越界了捏!");
        } catch (Exception exception) {
            System.out.println("代码都写不明白?");
        }

        try {
            System.out.println("数组的第十个数: " + numbers2[9]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("数组越界了捏!");
        } catch (Exception exception) {
            System.out.println("代码都写不明白?");
        }
    }

    public static double getNumber() {
        Scanner sc = new Scanner(System.in);
        double result = sc.nextDouble();
        if (result == 0) throw new ArithmeticException();
        return result;
    }
}
