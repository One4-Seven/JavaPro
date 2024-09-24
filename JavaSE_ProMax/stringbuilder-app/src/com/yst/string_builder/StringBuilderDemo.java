package com.yst.string_builder;

public class StringBuilderDemo {
    public static void main(String[] args) {
        // 认识 StringBuilder 了解他的基本方法使用
        StringBuilder sb = new StringBuilder();

        // 在末尾添加元素(绝大多数类型)
        sb.append("shx");
        sb.append("yst");
        sb.append(1);
        sb.append(2.5);
        sb.append(true);

        // 翻转整个容器
        sb.reverse();

        // 获取容器长度
        System.out.println("容器中的字符串长度: " + sb.length());

        System.out.println("翻转后的元素: " +sb);
    }
}
