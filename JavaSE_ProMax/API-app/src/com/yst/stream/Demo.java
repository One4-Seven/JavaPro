package com.yst.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        // 认识基本的 Stream 中的 API 操作
        // 类似于流水线操作 流上的数据值可以使用一次 建议使用链式编程
        // 单例集合
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, "shx", "yst", "ljw", "pjy");

        // 获取一个 Stream 对象
        strings.stream().forEach(s -> System.out.println(s + " * "));

        // 双例集合
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("shx", 21);
        hashMap.put("yst", 22);
        hashMap.put("ljw", 27);
        hashMap.put("pjy", 25);

        hashMap.keySet().stream().forEach(s -> System.out.println(s + " ** "));
        hashMap.entrySet().stream().forEach(s -> System.out.println(s + " *** "));

        // 数组
        Integer[] integers = {65, 66, 67, 68, 69};
        Arrays.stream(integers).forEach(s -> System.out.println(s + " $ "));

        // 一推零散数据 要确保统一数据类型
        // 底层是一个可变参数 默认形成一个数组 所以可以传递数组作为形参
        // 如果传递的是基本类型的数组 则会把数组整体作为操作对象 而不是其中的每个元素
        int[] numbers = {1, 2, 3, 4, 5};
        String[] animals = {"cat", "dog", "zsy", "tiger"};

        Stream.of("申恒旭", "杨思婷", "刘佳文", "黄海冰").forEach(s -> System.out.println(s + " ^_^ "));
        Stream.of(animals).forEach(s -> System.out.println(s + " @ "));
        Stream.of(numbers).forEach(s -> System.out.println(Arrays.toString(s) + " @@ "));

        // Stream 流的中间方法认识
        // filter 方法用于中间过滤元素
        ArrayList<String> names = new ArrayList<>();
        Collections.addAll(names, "张升源", "张三丰", "张良", "黄海冰", "张无忌", "王者荣耀", "金铲铲", "张氏三宝", "阿迪达斯", "王者荣耀");

        names.stream().filter(new Predicate<>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张");
            }
        }).forEach(s -> System.out.println(s + " & "));

        names.stream().filter(s -> s.length() == 3).forEach(s -> System.out.println(s + " && "));

        // limit 获取前面的元素
        // skip 跳过前几个元素
        names.stream().skip(3).limit(1).forEach(s -> System.out.println("张升源的真爱" + s));

        // distinct 去重 底层依赖 hashCode equals 方法
        names.stream().distinct().forEach(s -> System.out.println(s + " # "));

        // concat 把两个流和并为一个流
        Stream.concat(names.stream(), strings.stream()).forEach(s -> System.out.println(s + " ## "));

        // map 对流中的数据进行类型转化 不可以是基本数据类型
        Arrays.stream(integers).map(new Function<Integer, Character>() {
            @Override
            public Character apply(Integer integer) {
                return (char) integer.intValue();
            }
        }).forEach(System.out::println);

        Arrays.stream(integers).map(integer -> (char) integer.intValue()).forEach(s -> System.out.println(s + " % "));

        // 认识 Stream 流中的终结方法
        // count 方法返回流中的元素个数
        System.out.println(names.stream().count());

        // toArray 返回一个指定类型数组
        // 形参 value 表示流中的元素个数 也是创建的数组的长度
        System.out.println(Arrays.toString(names.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        })));

        System.out.println(Arrays.toString(names.toArray(String[]::new)));

        // collect 返回指定类型的集合
        // List
        ArrayList<String> users = new ArrayList<>();
        Collections.addAll(users, "申恒旭-21", "杨思婷-22", "彭佳怡-26", "刘佳文-24", "茅馨月-23", "徐艺凝-23");

        System.out.println(users.stream().collect(Collectors.toList()));

        // Set 会按照数据类型去重
        System.out.println(users.stream().collect(Collectors.toSet()));

        // Map 需要指定写键和值的规则 键不允许重复
        // Collectors.toMap 有两个形参 分别代表键和值的规则
        // s 代表流中的每一个元素 类似于两个 map 方法的结合 返回指定类型的值作为键和值
        System.out.println(users.stream().collect(Collectors.toMap(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.split("-")[0];
            }
        }, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s.split("-")[1]);
            }
        })));

        System.out.println(users.stream().collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.parseInt(s.split("-")[1]))));
    }
}
