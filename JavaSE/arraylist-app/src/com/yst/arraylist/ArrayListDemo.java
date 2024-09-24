package com.yst.arraylist;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        // 创建集合容器(默认为泛类列表)
        // 认识 API 中 ArrayList 类的方法  基本方法:增 删 改 查
        // 底层是一个 Object 类的数组 不断进行扩容以满足用户的需求
        ArrayList<String> list = new ArrayList<>();

        // 在末尾添加元素
        list.add("yst");
        list.add("love");
        list.add("MySQL");
        list.add("yst");
        list.add("over");
        System.out.println("初始列表: " + list);

        // 在指定位置添加元素
        list.add(1, "shx");
        System.out.println("添加元素后: " + list);

        // 返回元素个数
        System.out.println("目前列表中元素个数: " + list.size());

        // 删除指定未知的元素 返回值是删除的元素
        String del = list.remove(5);
        System.out.println("删除'" + del + "'元素后: " + list);

        // 删除指定值的元素(默认删除第一个) 返回值为 True False
        list.remove("yst");
        System.out.println("删除'yst'元素后: " + list);

        // 根据索引返回列表元素
        System.out.println("列表中的第三个元素: " + list.get(2));

        // 设置指定下标的元素
        list.set(2, "cute");
        System.out.println("替换值后: " + list);

        // 查看是否包含否元素 底层调用 equals 方法进行筛选
        if (list.contains("love")) {
            System.out.println("list 中包含'love'元素");
        } else {
            System.out.println("list 中不包含'love'元素");
        }

        // 判断集合是否非空
        if (list.isEmpty()) {
            System.out.println("集合为空");
        } else {
            System.out.println("集合非空");
        }

        // 获取集合长度
        System.out.println("集合元素个数: " + list.size());

        // 获取第一个元素
        System.out.println(list.getFirst());
    }
}
