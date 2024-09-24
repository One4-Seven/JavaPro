package com.yst.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUp {
    public static void main(String[] args) throws IOException {
        // 学会压缩流中的压缩方法
        // 将一整个文件夹压缩到指定路径下
        File oldFile = new File("IO-app\\111");

        // 获取压缩包的父级路径
        File dadFile  = oldFile.getParentFile();

        // 创建压缩包路径
        File newFile = new File(dadFile,oldFile.getName() + ".zip");

        // 创建压缩流
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(newFile));

        toZip(oldFile, zos, oldFile.getName());

        zos.close();
    }

    private static void toZip(File oldFile, ZipOutputStream zos, String name) throws IOException {
        // 获取文件夹下的路径
        File[] files = oldFile.listFiles();
        // 遍历文件夹内容
        for (File file : files) {
            // 是文件则拷贝
            if (file.isFile()) {
                // 创建 ZipEntry 对象
                ZipEntry entry = new ZipEntry(name + "\\" + file.getName());
                // ZipEntry 对象加入压缩包
                zos.putNextEntry(entry);
                FileInputStream fis = new FileInputStream(file);
                int a;
                while ((a = fis.read()) != -1) {
                    zos.write(a);
                }
                fis.close();
                zos.closeEntry();
            } else {
                // 递归处理文件夹 先创建文件夹的 ZipEntry 对象加入压缩包再递归
                ZipEntry entry = new ZipEntry(name + "\\" + file.getName() + "\\");
                zos.putNextEntry(entry);
                zos.closeEntry();
                toZip(file, zos, name + "\\" + file.getName());
            }
        }
    }
}
