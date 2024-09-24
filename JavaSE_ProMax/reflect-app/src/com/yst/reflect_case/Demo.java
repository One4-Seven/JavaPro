package com.yst.reflect_case;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class Demo {
    public static void main(String[] args) throws IllegalAccessException, IOException {
        // 反射案例
        Teacher teacher = new Teacher("黄海冰", 21, "女", "美丽动人");
        Car car = new Car("黄海冰的宝马", "举世唯双");

        saveObject(teacher);
        saveObject(car);
    }

    private static void saveObject(Object object) throws IllegalAccessException, IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("reflect-app\\info.txt", true));
        Class<?> clazz = object.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String name = declaredField.getName();
            Object value = declaredField.get(object);
            System.out.println(name + "=" + value);
            bw.write(name + "=" + value);
            bw.newLine();
        }
        bw.close();
    }
}
