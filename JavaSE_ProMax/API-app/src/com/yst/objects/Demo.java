package com.yst.objects;

import java.util.Objects;

public class Demo {
    public static void main(String[] args) {
        // 认识 objects 类
        Student s1 = new Student("申恒旭");
        Student s2 = new Student("杨思婷");
        Student s3 = new Student("申恒旭");
        Student s4 = null;

        // equals 方法会优先判断是否为空 再调用其自己的 equals 方法
        if (Objects.equals(s1, s2)) {
            System.out.println("s1 和 s2 完全相同");
        } else {
            System.out.println("s1 和 s2 存在空集合或不相同");
        }

        if (Objects.equals(s1, s3)) {
            System.out.println("s1 和 s3 完全相同");
        } else {
            System.out.println("s1 和 s3 存在空集合或不相同");
        }

        if (Objects.equals(s1, s4)) {
            System.out.println("s1 和 s4 完全相同");
        } else {
            System.out.println("s1 和 s4 存在空集合或不相同");
        }

        // isNull 方法
        System.out.println(Objects.isNull(s1));
        System.out.println(Objects.isNull(s4));

        // nonNull 方法
        System.out.println(Objects.nonNull(s2));
        System.out.println(Objects.nonNull(s4));
    }
}
