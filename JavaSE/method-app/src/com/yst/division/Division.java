package com.yst.division;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        // return 控制方法结束
        double a = 99;
        double b = 11;
        double c = 0;

        division(a, b);
        division(b, c);
        division(c, a);

        Scanner sc = new Scanner(System.in);
        System.out.println("给哥两个数,我帮你算算运势: ");
        double d = sc.nextDouble();
        double e = sc.nextDouble();

        division(d, e);
    }

    public static void division(double a, double b) {
        if(b == 0) {
            System.out.println("除数为零,哥们脑子没问题吧?");
            return;
        }
        System.out.println(a + " / " + b + " = " + a / b);
    }
}
