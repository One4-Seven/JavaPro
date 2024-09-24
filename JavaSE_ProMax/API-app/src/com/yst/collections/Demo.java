package com.yst.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo {
    public static void main(String[] args) {
        // 认识 Collections 类的一些方法
        // 只可以操作一些单例集合 List Set
        ArrayList<String> strings = new ArrayList<>();

        // 添加所有元素
        Collections.addAll(strings, "shx", "YST", "yst", "sb", "cnmlgb");
        System.out.println(strings);

        // 打乱集合
        Collections.shuffle(strings);
        System.out.println(strings);

        // 集合元素排序 默认采用已实现的排序规则 也可以传入比较器对象进行自定义排序
        Collections.sort(strings);
        System.out.println(strings);

        Collections.sort(strings, Comparator.comparingInt(String::length));
        System.out.println(strings);

        // 按照默认排序获得最大/最小值 也可以传入比较器对象进行自定义排序
        String max = Collections.max(strings);
        System.out.println(max);

        String min = Collections.min(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        System.out.println(min);

        // 利用二分查找寻找元素 返回下标 不存在返回-1 需要集合有序
        int index = Collections.binarySearch(strings, "shx");
        System.out.println(index);

        // 集合拷贝 会覆盖原数组 如果长度不足则会报错
        ArrayList<String> strs = new ArrayList<>();
        Collections.addAll(strs, "fuck", "fuck", "FUCK", "FUCK", "shit", "SHIT");
        System.out.println(strs);

        Collections.copy(strs, strings);
        System.out.println(strs);

        // 把集合的所有值都修改为指定值
        Collections.fill(strs, "love");
        System.out.println(strs);

        // 交换集合指定位置的元素
        Collections.swap(strings, 0, 4);
        System.out.println(strings);
    }
}
