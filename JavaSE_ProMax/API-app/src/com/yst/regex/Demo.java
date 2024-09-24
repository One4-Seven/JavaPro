package com.yst.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        // 简单认识正则表达式
        // 默认只匹配一个字符
        System.out.println("a".matches("[abc]"));
        System.out.println("a".matches("[def]"));
        System.out.println("a".matches("[^def]"));
        System.out.println("a".matches("[a-zA-Z]"));
        System.out.println("0".matches("[a-zA-Z]"));
        System.out.println("b".matches("[a-z&&[b-z]]"));
        System.out.println("a".matches("[a-z&&^[b-z]]"));
        System.out.println("-----------");

        // 预定义字符类
        // \s 空白字符 \d 数字 \w 字符包括下划线
        System.out.println("a".matches("."));
        System.out.println("a".matches("\\d"));
        System.out.println("a".matches("\\D"));
        System.out.println(" ".matches("\\s"));
        System.out.println("a".matches("\\S"));
        System.out.println("_".matches("\\w"));
        System.out.println("a".matches("\\W"));
        System.out.println("-----------");

        // Greedy 数量词
        System.out.println("abcd".matches("[a-z]{4}"));
        System.out.println("ab0d".matches("[a-z]{4}"));
        System.out.println("".matches("[a-z]?"));
        System.out.println("a".matches("[a-z]?"));
        System.out.println("".matches("[a-z]+"));
        System.out.println("wasd".matches("[a-z]+"));
        System.out.println("".matches("[a-z]*"));
        System.out.println("wasd0".matches("[a-z]+"));
        System.out.println("was0921WASD".matches("\\w{4,}"));
        System.out.println("was0921WASD".matches("\\w{4,7}"));
        System.out.println("-----------");

        // 进行信息爬取
        String string = "Java的版本更新是为了不断改进语言的功能、性能和安全性，同时也引入了新的语言特性和API。以下是Java版本更新的简要概述：\n" +
                "\n" +
                "1.Java 18（预计于2022年秋季发布）**：Java 18预计将继续改进Java语言和平台。尽管具体的功能尚未确定，但预计会包括一些语言和API的改进，以及性能和安全性方面的优化。\n" +
                "\n" +
                "2.Java 17（2021年9月发布）**：Java 17是Oracle宣布的新的长期支持（LTS）版本。它包括了一些新的语言特性和API改进，以及对性能和安全性的提升。此版本还移除了一些过时的功能，并提供了新的HTTP客户端API。\n" +
                "\n" +
                "3.Java 16（2021年3月发布）**：Java 16引入了一些新的语言特性，如Records（记录）、Pattern Matching for instanceof、Sealed Classes（封闭类）等。此外，还改进了垃圾收集器、嵌套、启动、自适应垃圾回收和其他功能。\n" +
                "\n" +
                "4.Java 15（2020年9月发布）**：Java 15引入了一些新的语言特性，如Sealed Classes Preview、Hidden Classes（隐藏类）、Text Blocks Preview等。此外，还包括了对垃圾回收器、嵌套、安全性和其他功能的改进。\n" +
                "\n" +
                "5.Java 14（2020年3月发布）**：Java 14引入了Pattern Matching for instanceof（instanceof模式匹配）和Switch Expressions（switch表达式）等语言特性。此外，还包括了对垃圾回收器、嵌套、其他语言特性和API的改进。\n" +
                "\n" +
                "6.Java 13（2019年9月发布）**：Java 13引入了Switch Expressions Preview（switch表达式预览）、Text Blocks Preview（文本块预览）等语言特性。此外，还包括了对垃圾回收器、嵌套、其他语言特性和API的改进。\n" +
                "\n" +
                "7.Java 12（2019年3月发布）**：Java 12引入了局部变量类型推断、Switch表达式、新的字符串方法等语言特性。此外，还包括了对垃圾回收器、嵌套、其他语言特性和API的改进。\n" +
                "\n" +
                "每个新版本的发布都旨在使Java语言和平台更加强大、高效和安全，以满足不断变化的编程需求。";

        // 创建一个正常表达式对象
        Pattern p1 = Pattern.compile("Java\\s?[\\d]*");

        // Java 后面加上 8 或 12 最后返回的依旧是字符串 Java 用于条件筛选
        // Java(?:12|8) 返回字符串包含后面的数字 Java(?!12|8) 返回字符串不包含后面的数字
        Pattern p2 = Pattern.compile("Java(?=12|8)");

        // 获取文本匹配器对象
        // 利用文本匹配器对象去读取文件内容 按照正则表达式对象的规则匹配
        Matcher m1 = p1.matcher(string);

        // find 方法会去指定文本中寻找符合正则表达式的字符子串 返回值为布尔类型 并在底层起始索引和结束索引加一
        // group 方法会根据底层记录的索引利用 subString 方法截取目标子串并返回
        while (m1.find()) {
            String group = m1.group();
            System.out.println(group);
        }

        System.out.println("-----------");

        // Java 默认是贪婪爬取 使用 ? 修改爬取模式
        String a = "abbbbbbbbbbbbbbbbbaaaa";

        Pattern p3 = Pattern.compile("ab+");
        Pattern p4 = Pattern.compile("ab+?");

        Matcher m2 = p3.matcher(a);
        Matcher m3 = p4.matcher(a);

        while (m2.find()) {
            String group = m2.group();
            System.out.println(group);
        }

        while (m3.find()) {
            String group = m3.group(0);
            System.out.println(group);
        }

        System.out.println("-----------");

        // replaceAll 方法按照正则表达式替换字符串
        String b = "申恒旭213dnhadnald喜欢798134192jkabndjka杨思婷";
        String result1 = b.replaceAll("\\w+", "");
        System.out.println(result1);

        // split 方法按照正则表达式切割字符串
        String[] strings = b.split("\\w+");
        for (String str : strings) {
            System.out.println(str);
        }

        System.out.println("-----------");

        // 对数字进行转义 \\ 组号 表示之出现过的组号 复用
        // 首尾相同
        String regex1 = "(.).+\\1";
        System.out.println("a123a".matches(regex1));
        System.out.println("b123b".matches(regex1));
        System.out.println("a123c".matches(regex1));

        // 首尾相同 而且是同一字符
        String regex2 = "((.)\\2*).+\\1";
        System.out.println("aaa123aaa".matches(regex2));
        System.out.println("abc123abc".matches(regex2));
        System.out.println("ccc123ccc".matches(regex2));

        // 外部复用组号 去重 $ 组号
        String speak = "申申恒恒恒恒旭旭旭旭旭喜喜喜喜喜欢欢欢欢杨杨杨杨杨杨杨杨思思思思思思婷婷婷婷婷婷婷婷婷婷婷婷";
        String result2 = speak.replaceAll("(.)\\1+", "$1");
        System.out.println(result2);
    }
}
