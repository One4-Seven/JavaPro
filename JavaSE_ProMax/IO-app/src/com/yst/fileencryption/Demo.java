package com.yst.fileencryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        // 利用所学加密文件
        // IO-app\text\copy.jpg 加密源
        // IO-app\text\encipher.jpg 加密后
        // IO-app\text\decrypt.jpg 解密后
        int key = 147;
        File file1 = new File("IO-app\\text\\copy.jpg");
        File file2 = new File("IO-app\\text\\encipher.jpg");
        File file3 = new File("IO-app\\text\\decrypt.jpg");

        FileInputStream fileInputStream = new FileInputStream(file2);
        FileOutputStream fileOutputStream = new FileOutputStream(file3);

        int a;
        while ((a = fileInputStream.read()) != -1) {
            fileOutputStream.write(a ^ key);
        }

        fileOutputStream.close();
        fileInputStream.close();
    }

}
