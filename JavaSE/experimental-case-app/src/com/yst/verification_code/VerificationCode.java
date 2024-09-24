package com.yst.verification_code;

import java.util.Random;

public class VerificationCode {
    public static void main(String[] args) {
        // 随机生成多位验证法
        String code1 = creatCode(6);
        System.out.println("您的六位验证码: " + code1);

        String code2 = creatCode(10);
        System.out.println("您的十位验证码: " + code2);
    }

    public static String creatCode(int n) {
        Random r = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int m = r.nextInt(3);
            switch (m) {
                // 生成0-9随机数字
                case 0:
                    result.append(r.nextInt(10));
                    break;

                // 生成A-Z随机字母
                case 1:
                    char ch1 = (char) (r.nextInt(26) + 65);
                    result.append(ch1);
                    break;

                // 生成a-z随机字母
                case 2:
                    char ch2 = (char) (r.nextInt(26) + 97);
                    result.append(ch2);
                    break;
            }
        }
        return result.toString();
    }
}
