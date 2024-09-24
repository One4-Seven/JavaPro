package com.yst.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // 第三方库 经典白学
        // 读取文件内容 按行切割 返回集合 需要绝对路径
        List<String> strings = FileUtil.readLines("E:\\Java\\JavaSE_ProMax\\IO-app\\commons_IO\\yst.txt", "UTF-8");
        System.out.println(strings);

        // 续写文件
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "shx", "yst", "pjt");
        FileUtil.appendLines(list, "E:\\Java\\JavaSE_ProMax\\IO-app\\commons_IO\\yst.txt", "UTF-8");

        // 写出数据 相对于当前软件包在 out 文件夹的位置与 class 文件存放在一起
        FileUtil.writeLines(list, "yst.txt", "UTF-8");

        // 创建文件路径 touch 创建文件 父级路径不存在会自动创建
        File file = FileUtil.file("E:\\Java" + "\\JavaSE_ProMax" + "\\IO-app" + "\\commons_IO" + "\\newdir" + "\\secret.txt");
        FileUtil.touch(file);

        // 爬取网络数据
        String net = "https://m.meimingteng.com/m/zhishi/qimingdaquan/haotingdemingzi/s.aspx?id=9339";
        String string = HttpUtil.get(net);
        List<String> all = ReUtil.findAll("\\d{3} ([\\u4E00-\\u9FA5]{2})", string, 1);
        System.out.println(all);
    }
}
