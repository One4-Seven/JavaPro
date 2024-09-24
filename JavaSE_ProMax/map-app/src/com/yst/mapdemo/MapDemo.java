package com.yst.mapdemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class MapDemo {
    public static void main(String[] args) {
        // 认识双例集合 Map 一般存储键值对 Entry
        // Map 接口时所有双例集合的根接口
        Map<String, String> map = new HashMap<>();

        // 添加键值对
        map.put("张升源","黄海冰");
        map.put("申恒旭","杨思婷");
        map.put("流星雨","还没有");
        map.put("曹睿眼","查一次");
        System.out.println(map);

        // 覆盖键值对 返回被覆盖的值
        String put = map.put("张升源", "无");
        System.out.println(put);

        // 删除键值对
        map.remove("曹睿眼");
        System.out.println(map);

        // 检查键是否存在
        if (map.containsKey("申恒旭")) {
            System.out.println("存在指定键");
        } else {
            System.out.println("不存在指定键");
        }

        // 检查值是否存在
        if (map.containsValue("查一次")) {
            System.out.println("存在指定值");
        } else {
            System.out.println("不存在指定值");
        }

        // 返回元素个数
        System.out.println("集合长度: " + map.size());

        // 清空集合
        map.clear();
        System.out.println("清空集合");

        // 判断集合非空
        if (map.isEmpty()) {
            System.out.println("集合为空");
        } else {
            System.out.println("集合不为空");
        }

        // 遍历键值对元素
        // 利用键找值
        map.put("张升源","黄海冰");
        map.put("申恒旭","杨思婷");
        map.put("流星雨","还没有");
        map.put("曹睿眼","查一次");

        // keySet 获取 Map 中的所有键存入 Set 集合中
        Set<String> strings = map.keySet();

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next + " = " + map.get(next));
        }
        System.out.println("----------------");

        // 利用键值对遍历集合
        // entrySet 获取 Map 中的所有键值对存入 Set 集合中
        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("----------------");

        // 利用 forEach 遍历键值对
        // 底层调用 entrySet 方法获取每一个键值对的键和值
        // 最后传递给 accept 方法实现调用
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + " = " + value);
            }
        });
    }
}
