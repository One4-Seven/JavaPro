package com.yst.puzzle_game;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {
    public static String getCode(){
        // 创建一个集合
        ArrayList<Character> list = new ArrayList<>();

        // 添加字母 a - z  A - Z
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));//a - z
            list.add((char)('A' + i));//A - Z
        }

        // 生成4个随机字母
        StringBuilder result = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            // 获取随机索引
            int randomIndex = r.nextInt(list.size());
            char c = list.get(randomIndex);
            result.append(c);
        }

        // 在后面拼接数字
        int number = r.nextInt(10);

        // 把随机数字拼接到result的后面
        result.append(number);

        // 把字符串变成字符数组
        char[] chars = result.toString().toCharArray();

        // 在字符数组中生成一个随机索引
        int index = r.nextInt(chars.length);

        // 拿着索引上的数字，跟随机索引上的数字进行交换
        char temp = chars[4];
        chars[4] = chars[index];
        chars[index] = temp;

        // 把字符数组再变回字符串
        return new String(chars);
    }
}
