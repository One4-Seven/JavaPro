package com.yst.runtime;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 认识 RunTime Java虚拟机运行环境
        // 获取 Java虚拟机运行环境对象(单例) 构造器私有
        Runtime rt = Runtime.getRuntime();

        // 查看虚拟机的一些属性
        System.out.println("当前Java虚拟机运行环境配置: ");
        System.out.println("总线程数: " + rt.availableProcessors());
        System.out.println("总内存大小: " + rt.maxMemory() / 1024 / 1024 + "Mb");
        System.out.println("已占用的内存: " + rt.totalMemory() / 1024 / 1024 + "Mb");
        System.out.println("未使用的内存: " + rt.freeMemory() / 1024 / 1024 + "Mb");

        // 运行 cmd 命令
        rt.exec("notepad");
    }
}
