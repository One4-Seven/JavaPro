package com.yst.string_demo;

public class StringDemo {
    public static void main(String[] args) {
        // 创建 String 对象的四种基本方式 String 对象是不可变的字符串对象
        // 双引号创建的字符串对象会存放于字符串常量池中(位于堆内存) 再次有相同的对象创建时会被赋予相同的地址
        // 使用 new 关键字创建字符串对象 每次都会创建新的对象 占用推内存 产生新地址
        String rs1 = "Yang Si Ting";
        System.out.println(rs1);

        String rs2 = new String();
        System.out.println(rs2);

        char[] chs = {'Y', 'S', 'T'};
        String rs3 = new String(chs);
        System.out.println(rs3);

        byte[] bts = {65, 97, 66, 98};
        String rs4 = new String(bts);
        System.out.println(rs4);

        String rs5 = new String("yst");
        String rs6 = "yst";
        System.out.println(rs5 == rs6 ? "rs5 和 rs6 存储的地址相同" : "rs5 和 rs6 存储的地址不相同");

        // 认识 API 中 String 类的方法
        String text = "I Love Yst!";
        String copy = "I Love Yst!";
        String lowcopy = "i love yst!";
        String newtext = "I Love Ljw!";

        // 获取字符串长度
        System.out.println("text 字符串的长度为: " + text.length());

        // 用下标访问字符串返回单个字符
        System.out.println("字符串: " + text);
        System.out.println("字符串中的第三个字符: " + text.charAt(2));

        // 把字符串转换为字符数组返回
        char[] chars = text.toCharArray();
        System.out.println("字符数组中的第三个元素: " + chars[2]);

        // 比较两个字符串是否相等
        System.out.println(text.equals(copy) ? "text 和 copy 存储的内容相同!" : "text 和 copy 存储的内容不同!");
        System.out.println(text.equals(newtext) ? "text 和 newtext 存储的内容相同!" : "text 和 newtext 存储的内容不同!");

        // 忽略大小写比较字符串是否相等
        System.out.println(text.equalsIgnoreCase(lowcopy) ? "text 和 lowtext 存储的内容相同!" : "text 和 lowtext 存储的内容不同!");

        // 截取字符串(不包含结尾)
        System.out.println("字符串前五个字符: " + text.substring(0,5));

        // 不提供结尾默认截取到结尾
        System.out.println("字符串最后五个元素: " + text.substring(6));

        // 字符串替换
        System.out.println("替换空格后的新字符串: " + text.replace(" ", "_*_"));

        // 判断字符串是否包含特定元素
        System.out.println(text.contains("Love") ? "字符串中包含Love " : "字符串中不包含Love");

        // 判断字符串是否以特定字符开头
        System.out.println(text.startsWith("I L") ? "字符串以 'I L' 开头" : "字符串不以 'I L' 开头");

        // 按指定分隔符分割字符串 返回一个字符串数组
        String[] texts = text.split(" ");
        System.out.print("以空格为分隔符分割后的字符串数组: [");
        for (int i = 0; i < texts.length; i++) {
            if (i == texts.length -1) {
                System.out.print(texts[i]);
            } else {
                System.out.print(texts[i] + ", ");
            }
        }
        System.out.println(']');

    }
}
