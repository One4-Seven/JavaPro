package com.yst.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.function.Consumer;

public class HashSetDemo {
    public static void main(String[] args) {
        // 认识 哈希集合 和基本原理
        // 底层利用数组链表和哈希树组合实现
        // 利用 hashCode 方法获取新元素存放的位置 有元素则在下方形成链表
        // 当数组和链表超过指定数 链表转换为红黑树
        // 创建哈希集合 需要重写定义类型的 hashCode equals 方法
        HashSet<Student> students = new HashSet<>();

        students.add(new Student("shx", 21));
        students.add(new Student("shx", 21));
        students.add(new Student("yst", 22));
        students.add(new Student("ljw", 23));
        students.add(new Student("pjy", 24));

        for (Student student : students) {
            System.out.println(student);
        }

        // 创建有序哈希集合 需要重写定义类型的 hashCode equals 方法
        // 可以做到有序遍历 利用双向链表来实现
        LinkedHashSet<Student> stus = new LinkedHashSet<>();

        stus.add(new Student("申恒旭", 21));
        stus.add(new Student("申恒旭", 21));
        stus.add(new Student("杨思婷", 22));
        stus.add(new Student("刘佳文", 23));
        stus.add(new Student("彭佳怡", 24));

        for (Student student : stus) {
            System.out.println(student);
        }

        Iterator<Student> iterator = stus.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            System.out.println(next);
        }

        stus.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });
    }
}
