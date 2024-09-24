package com.yst.hashmap;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        // 认识哈希 Map 集合原理同哈希 Set 无序 不重复 无索引
        // LinkedHashMap 有序 不重复 无索引
        // 只会对键值对中的键进行 hashCode 方法获取哈希值
        // 只有当键值对中的键是自定义类时需要重写 hashCode equals 方法
        HashMap<Student, String> hashMap = new HashMap<>();

        hashMap.put(new Student("申恒旭", 21), "苏州");
        hashMap.put(new Student("杨思婷", 21), "吴中");
        hashMap.put(new Student("刘佳文", 21), "震泽");
        System.out.println(hashMap);

        hashMap.forEach((key, value) -> System.out.println(key + " 居住地: " + value));

    }
}
