package com.yst.web_crawler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 利用 IO流 和正则表达式规则在网络上爬取数据
        // 生成随机的男女姓名
        String surname = "http://baijiaxing.wiicha.com/";
        String boy = "https://www.meimingteng.com/subject/qimingdaquan/nanhaiqiming/s.aspx?newsid=12937";
        String girl = "https://www.daodoc.com/fanwen/qitafanwen/16643521698804134.html";

        String result1 = webCrawler(surname);
        String result2 = webCrawler(boy);
        String result3 = webCrawler(girl);

        ArrayList<String> first = getDate(result1, "(\\d+)\\.(\\W{1})", 2);
        ArrayList<String> second1 = getDate(result2, "(\\d{3})、(\\W{2})", 2);
        ArrayList<String> second2 = getDate(result3, "\\.(..)。", 1);

        // 自动去重
        HashSet<String> names = new HashSet<>();

        // 打乱姓
        Collections.shuffle(first);

        // 打乱名
        Collections.shuffle(second1);
        Collections.shuffle(second2);

        // 随机年龄
        Random r = new Random();

        // 随机男生
        for (int i = 0; i < second1.size(); i++) {
            int age = r.nextInt(18, 30);
            String name = first.get(i) + second1.get(i) + "-男-" + age;
            names.add(name);
        }

        // 随机女生
        for (int i = 0; i < second2.size(); i++) {
            int age = r.nextInt(18, 28);
            String name = first.get(i) + second2.get(i) + "-女-" + age;
            names.add(name);
        }

        // 把数据写入本地文档保存
        BufferedWriter bw = new BufferedWriter(new FileWriter("experimental-case-app\\information\\users.txt"));

        for (String name : names) {
            bw.write(name);
            bw.newLine();
        }

        bw.close();
    }

    private static ArrayList<String> getDate(String oldDate, String regex, int index) {
        ArrayList<String> answer = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(oldDate);
        while (matcher.find()) {
            answer.add(matcher.group(index));
        }
        return answer;
    }

    // 爬取网页中的所有信息
    private static String webCrawler(String net) throws IOException {
        StringBuilder sb = new StringBuilder();
        // 创建 URL 对象
        URL url = new URL(net);
        // 建立网络连接
        URLConnection content = url.openConnection();
        // 获取字节流读取并转换为字符流
        InputStreamReader isr = new InputStreamReader(content.getInputStream());

        int a;
        while ((a = isr.read()) != -1) {
            sb.append((char) a);
        }

        return sb.toString();
    }
}
