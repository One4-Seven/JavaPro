package com.yst.directorycopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 拷贝文件夹
        File file = new File("IO-app\\text");
        File newfile = new File("IO-app\\copy");

        long start = System.currentTimeMillis();
        copyDirectory(file, newfile);
        long end = System.currentTimeMillis();
        System.out.println("本次文件夹拷贝耗时: " + (end - start) + "ms");
    }

    private static void copyDirectory(File file, File newfile) throws IOException {
        // 先创建目标文件夹 防止路径错误
        newfile.mkdirs();

        // 获取父文件夹的子目录
        File[] files = file.listFiles();

        // 依次遍历每个子目录
        for (File file1 : files) {
            // 如果是文件则直接复制
            if (file1.isFile()) {
                System.out.println(file1.toString());
                FileInputStream fis = new FileInputStream(file1);
                // 拷贝的地址为目标文件夹的目录加上父文件夹子目录的名字
                FileOutputStream fos = new FileOutputStream(new File(newfile, file1.getName()));

                int len;
                byte [] bytes = new byte[1024];
                while ((len = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }

                // 结束程序对该文件的内存占用
                fos.close();
                fis.close();
            } else {
                // 是文件夹则递归处理
                copyDirectory(file1, new File(newfile, file1.getName()));
            }
        }
    }
}
