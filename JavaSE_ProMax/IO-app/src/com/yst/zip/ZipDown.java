package com.yst.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipDown {
    public static void main(String[] args) throws IOException {
        // 认识压缩流中的解压操作
        // 根据要解压的文件创建解压流
        ZipInputStream zis = new ZipInputStream(new FileInputStream("IO-app\\likes.zip"), Charset.forName("UTF-8"));

        // 指定要解压到的文件路径
        File file = new File("IO-app\\zip_down");

        // ZipEntry 对象存放的是所有压缩包中子目录
        ZipEntry entry;

        // 依次获取压缩包每个子目录 不包含压缩包层级
        while ((entry = zis.getNextEntry()) != null) {
            System.out.println(entry);
            // 处理文件夹
            if (entry.isDirectory()) {
                // 用目标目录加上读取的子目录名
                File files = new File(file, entry.toString());
                // 创建文件夹
                files.mkdirs();
            } else {
                FileOutputStream fos = new FileOutputStream(new File(file, entry.toString()));
                int a;
                while ((a = zis.read()) != -1) {
                    fos.write(a);
                }
                fos.close();
                // 表示压缩包中的一个文件处理完毕
                zis.closeEntry();
            }
        }
        // 关闭压缩流
        zis.close();
    }
}
