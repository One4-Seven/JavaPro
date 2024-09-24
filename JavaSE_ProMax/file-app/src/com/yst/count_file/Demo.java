package com.yst.count_file;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        // 统计指定路径下的文件后缀格式及数量
        File file = new File("E:\\Java\\JavaSE_ProMax");
        System.out.println(countFiles(file));
    }

    private static HashMap<String, Integer> countFiles(File file) {
        HashMap<String, Integer> result = new HashMap<>();
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                String name = file1.getName();
                String[] names = name.split("\\.");
                if (names.length >= 2) {
                    String end = names[names.length -1];
                    if (result.containsKey(end)) {
                        int count = result.get(end);
                        result.put(end, count + 1);
                    } else {
                        result.put(end, 1);
                    }
                }
            } else {
                HashMap<String, Integer> son = countFiles(file1);
                Set<Map.Entry<String, Integer>> entries = son.entrySet();
                for (Map.Entry<String, Integer> entry : entries) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    if (result.containsKey(key)) {
                        int count = result.get(key);
                        result.put(key, count + value);
                    } else {
                        result.put(key, value);
                    }
                }
            }
        }
        return result;
    }
}
