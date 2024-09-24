package com.yst.iterator;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.function.Consumer;

public class Demo {
    public static void main(String[] args) {
        // Collection 类是所有单例集合的接口父类
        // Collection 类主要包含包含两大实现类 List 和 Set
        // List 有序 可重复 有索引
        // Set 无序 不可重复 无索引
        // ArrayList 属于 List 类的子类
        // 认识集合的通用索引迭代器对象
        ArrayList<String> strings = new ArrayList<>();
        strings.add("shx");
        strings.add("yst");
        strings.add("ljw");
        strings.add("pjy");
        strings.add("mxy");
        strings.add("xyn");

        // 获取迭代器对象 默认指向零索引处 Iterator
        // 遍历过程要修改集合内容要调用列表迭代器对象的方法 ListIterator
        // Iterator ListIterator 的基本方法用法相同
        // hasNext 方法判断当前位置是否为空 next 返回当前位置的值并移动迭代器至下一位
        ListIterator<String> iterator = strings.listIterator();

        System.out.print("当前集合中的元素: ");
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (string.equals("shx")) {
                iterator.add("love");
            }
            System.out.print(string + " ");
        }
        System.out.println();

        // 增强 for 循环遍历集合
        System.out.print("当前集合中的元素: ");
        for (String string : strings) {
            System.out.print(string + " ");
        }
        System.out.println();

        // 调用 forEach 方法遍历集合
        // forEach 底层调用 accept 方法循环遍历集合元素
        System.out.print("当前集合中的元素: ");
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        });
        strings.forEach(s -> System.out.print(s + " "));
    }
}