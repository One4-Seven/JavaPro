package com.yst.treeset;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        // 认识 TreeSet 底层逻辑是红黑树
        // TreeSet 不重复 无索引 可排序(实现比较器对象)
        // 定义类要实现 Comparable 接口中的 compareTo 方法
        TreeSet<Teacher> teachers = new TreeSet<>();

        teachers.add(new Teacher("zsy", 21));
        teachers.add(new Teacher("shx", 22));
        teachers.add(new Teacher("yst", 23));
        teachers.add(new Teacher("hhb", 24));
        teachers.add(new Teacher("pjy", 21));
        teachers.add(new Teacher("pjy", 21));

        for (Teacher teach : teachers) {
            System.out.println(teach);
        }

        System.out.println("------------------------------");

        // 如果要调用的类已经重写了实现了 Comparable 接口中的 compareTo 方法
        // 可以在 TreeSet 方法后增加一个参数 传递一个比较器对象
        TreeSet<Teacher> ts = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        ts.add(new Teacher("abc", 21));
        ts.add(new Teacher("aaa", 22));
        ts.add(new Teacher("yst", 25));
        ts.add(new Teacher("xcb", 24));
        ts.add(new Teacher("xxx", 27));

        for (Teacher t : ts) {
            System.out.println(t);
        }

    }
}
