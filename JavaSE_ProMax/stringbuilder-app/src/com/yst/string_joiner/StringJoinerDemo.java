package com.yst.string_joiner;

import java.util.StringJoiner;

public class StringJoinerDemo {
    public static void main(String[] args) {
        // 认识 StringJoiner
        // 两种带参构造方法 (分隔符) (分隔符, 开始符号, 结束符号)
        StringJoiner sj = new StringJoiner(", ", "[", "]");

        sj.add("shx").add("love").add("yst");
        System.out.println("容器中的字符串长度: " + sj.length());

        System.out.println("拼接结果: " + sj);
    }
}
