package com.yst.static_demo;

import java.util.Random;

// 工具类 构造方法私有 只存放类方法
public class Util {

    // 私有构造方法
    private Util() {
    }

    // 类方法
    public static String createcode(int n) {
        StringBuilder code = new StringBuilder();
        String date = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int index = r.nextInt(date.length());
            code.append(date.charAt(index));
        }
        return code.toString();
    }
}
