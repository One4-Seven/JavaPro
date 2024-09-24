package com.yst.file_demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 认识文件的基本方法
        File f1 = new File("file-app\\text");
        System.out.println(f1.exists());
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println("--------------------------------------------------");

        File f2 = new File("file-app\\text\\animals.txt");
        System.out.println(f2.exists());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
        System.out.println("--------------------------------------------------");

        // 无法获取文件夹的大小 返回单位是字节
        System.out.println(f1.length() + " 字节");
        System.out.println(f2.length() + " 字节");
        System.out.println("--------------------------------------------------");

        System.out.println(f1.getAbsolutePath());
        System.out.println(f2.getAbsolutePath());
        System.out.println(f1.getPath());
        System.out.println(f2.getPath());
        System.out.println("--------------------------------------------------");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.out.println(f1.getName());
        // 返回最后的修改时间(ms)
        Date d1 = new Date(f1.lastModified());
        System.out.println(simpleDateFormat.format(d1));
        System.out.println(f2.getName());
        Date d2 = new Date(f2.lastModified());
        System.out.println(simpleDateFormat.format(d2));
        System.out.println("--------------------------------------------------");

        // 创建文件没有后缀也是文件 如果父路径不存在则会抛出异常
        File f3 = new File("file-app\\text\\ccc");
        File f4 = new File("file-app\\text\\ddd.txt");
        System.out.println(f3.createNewFile());
        System.out.println(f4.createNewFile());
        System.out.println("--------------------------------------------------");

        // mkdir 方法只能够创建单级文件夹 无法创建多级文件夹
        File f5 = new File("file-app\\text\\aaa\\sb");
        File f6 = new File("file-app\\text\\bbb\\cnm\\sb");
        System.out.println(f5.mkdir());
        System.out.println(f6.mkdirs());
        System.out.println("--------------------------------------------------");

        // 删除文件和空文件夹 如果存在东西则不会删除 不经过回收站
        File f7 = new File("file-app\\text\\eee.txt");
        System.out.println(f7.delete());
        System.out.println(f6.delete());
        System.out.println("--------------------------------------------------");

        // 获取文件夹下的所有文件对象存放在一个数组中返回
        // 如果文件夹路径不存在或者没有权限访问 返回 null 或者该路径为一个文件也返回 null
        // 该方法可以获得所有文件 包含被隐藏的文件或文件夹 但如果文件夹为空则返回一个空数组
        File f8 = new File("file-app\\text");
        for (File file : f8.listFiles()) {
            System.out.println(file);
        }
    }
}
