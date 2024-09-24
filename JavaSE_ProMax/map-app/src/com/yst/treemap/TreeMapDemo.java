package com.yst.treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        // 认识 TreeMap 可排列 不重复 无索引
        // 可排列仅对键生效 如果键是自定义类 必须实现可排序接口
        TreeMap<Student, String> treeMap = new TreeMap<>();

        treeMap.put(new Student("shx", 21), "苏州");
        treeMap.put(new Student("yst", 21), "苏州");
        treeMap.put(new Student("pjy", 27), "吴江");
        treeMap.put(new Student("ljw", 25), "浙江");
        treeMap.put(new Student("ljz", 25), "黑龙江");

        for (Map.Entry<Student, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " 居住地: " + entry.getValue());
        }
        System.out.println("------------------------------------------");

        // 对于 Java 中已经定义好排序规则的类来说过
        // 在使用 TreeMap<>() 方法时传递一个比较器对象(匿名类)
        TreeMap<Integer, String> tm1 = new TreeMap<>();

        // 会自动按照升序排序
        tm1.put(3,"可乐");
        tm1.put(5,"阿萨姆");
        tm1.put(4,"尖叫");

        System.out.println(tm1);
        System.out.println("------------------------------------------");

        // 创建 TreeMap 对象是规定排序规则
        TreeMap<Integer, String> tm2 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        tm2.put(3,"可乐");
        tm2.put(5,"阿萨姆");
        tm2.put(4,"尖叫");

        System.out.println(tm2);
    }
}
