package com.yst.commons_IO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 第三方库 经典白学
        File file1 = new File("IO-app\\commons_IO\\yst.txt");
        File file2 = new File("IO-app\\commons_IO\\copy\\yst.txt");
        File file3 = new File("IO-app\\commons_IO\\copy");
        File file4 = new File("IO-app\\commons_IO\\copys");
        File file5 = new File("IO-app\\commons_IO\\copydir");
        File file6 = new File("IO-app\\commons_IO\\111");

        // FileUtils
        // 拷贝文件
        FileUtils.copyFile(file1, file2);

        // 拷贝文件夹内容
        FileUtils.copyDirectory(file3, file4);

        // 拷贝整个文件夹
        FileUtils.copyDirectoryToDirectory(file3, file5);

        // 清空文件夹内容
        FileUtils.cleanDirectory(file4);

        // 删除文件夹
        FileUtils.deleteDirectory(file6);

        // 读入文件
        System.out.println(FileUtils.readFileToString(file1));

        // 写出数据 会清空当前文件
        FileUtils.write(file1,"shx\nyst\nshx");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        FileReader fr = new FileReader(file2);
        FileWriter fw = new FileWriter("IO-app\\commons_IO\\copys\\yst.txt");

        // IOUtils
        // 复制文件
        IOUtils.copy(fis, fos);

        // 读取文件
        System.out.println(IOUtils.readLines(fr));

        // 写出文件
        IOUtils.write("hahahah", fw);
    }
}
