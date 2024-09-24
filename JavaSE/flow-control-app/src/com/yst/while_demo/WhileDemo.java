package com.yst.while_demo;

public class WhileDemo {
    public static void main(String[] args) {
        // while 循环结构
        double high = 8848860;
        double low = 0.1;
        int count = 0;
        while(low <= high) {
            low *= 2;
            count++;
        }
        System.out.println("将一张纸折叠" + count + "次后,它的厚度会超过珠穆朗玛峰!");
        System.out.println("最终这张纸的厚度为" + (int)low + "m!");
        System.out.println("珠穆朗玛峰的高度为8848860m!");

        // do-while 循环结构
        int ddl = 3;
        int all = ddl;
        do {
            System.out.println("快点放假!");
            ddl--;
        } while (ddl > 0);
        System.out.println("熬了整整" + all + "天,终于放假了!");
    }
}
