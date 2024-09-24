package com.yst.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class Demo {
    public static void main(String[] args) {
        // 认识使用 Set 无序 不可重复 无索引
        // HashSet 无序 不可重复 无索引
        // LinkedHashSet 有序 不可重复 无索引
        Set<String> strings = new HashSet<>();

        // 添加元素可能会失败
        boolean res1 = strings.add("shx");
        boolean res2 = strings.add("shx");

        System.out.println(res1);
        System.out.println(res2);

        strings.add("yst");
        strings.add("ljw");

        // 无序
        System.out.println(strings);

        // 遍历集合
        // 利用迭代器
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
        }

        // 增强 for 循环
        for (String str : strings) {
            System.out.println(str);
        }

        // forEach 方法
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        strings.forEach(System.out::println);

    }
}
