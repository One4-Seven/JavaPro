package com.yst.file_case;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        // 利用 File 完成一些基本案例
        // 寻找电脑中的所有 mp4 文件并返回
        findMP4();
    }

    private static void findMP4() {
        File[] arr = File.listRoots();
        for (File file : arr) {
            findMP4(file);
        }
    }

    private static void findMP4(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File file1 : files) {
                if (file1.isFile()) {
                    if (file1.getName().endsWith(".mp4")) {
                        System.out.println(file1);
                    }
                } else {
                    findMP4(file1);
                }
            }
        }
    }
}
