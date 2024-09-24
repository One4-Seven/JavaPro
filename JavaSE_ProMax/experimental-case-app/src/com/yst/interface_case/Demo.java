package com.yst.interface_case;

public class Demo {
    public static void main(String[] args) {
        // 模拟班级人员和平均分展示的两种模式 应用接口实现
        // 创建整个班级实例对象
        ClassRoom1 class1 = new ClassRoom1();
        ClassRoom2 class2 = new ClassRoom2();

        // 第一种实现类实例方法
        class1.printAll();
        class1.printAverage();

        // 第二种实现类实例方法
        class2.printAll();
        class2.printAverage();
    }
}
