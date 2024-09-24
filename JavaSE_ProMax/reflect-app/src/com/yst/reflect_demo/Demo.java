package com.yst.reflect_demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 认识基本的反射原理
        // 利用反射对象获取构造方法 成员变量 成员方法类似不一一举例
        // 获取字节码文件的三种方式
        Class<?> clazz1 = Class.forName("com.yst.reflect_demo.Student");
        Class<?> clazz2 = Student.class;
        Student student = new Student();
        Class<?> clazz3 = student.getClass();

        System.out.println((clazz1 == clazz2) && (clazz2 == clazz3));
        System.out.println("-------------------------------------------------------");

        // 利用字节码文件分析类
        // 获取所有公共的构造方法
        Constructor<?>[] constructors = clazz1.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-------------------------------------------------------");

        // 获取所有的构造方法
        Constructor<?>[] declaredConstructors = clazz1.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("-------------------------------------------------------");

        // 获取指定参数类型的构造方法(公开方法)
        Constructor<?> Constructor = clazz1.getConstructor(String.class, int.class);
        // 获取修饰符
        System.out.println(Constructor.getModifiers());
        // 获取形参类型
        Parameter[] parameters = Constructor.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        // 创建对象
        Student instance = (Student) Constructor.newInstance("炸鱼哥", 19);
        System.out.println(instance);
        System.out.println("-------------------------------------------------------");

        // 获取指定参数类型的构造方法(私有方法)
        Constructor<?> declaredConstructor = clazz1.getDeclaredConstructor(String.class);
        System.out.println(declaredConstructor.getModifiers());
        // 临时取消权限效验
        declaredConstructor.setAccessible(true);
        Object newedInstance = declaredConstructor.newInstance("杨思婷");
        System.out.println(newedInstance);
        System.out.println("-------------------------------------------------------");
    }
}
