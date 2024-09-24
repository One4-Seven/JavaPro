package com.yst.interface_case;

import java.util.ArrayList;

public class ClassRoom1 {
    private final ArrayList<Student> students = new ArrayList<>();

    // 创建班级实例的同时创建造作类实例
    private final Operator operator = new OperatorImpl1();
    public ClassRoom1() {
        students.add(new Student("杨思婷", 21, "女", 100));
        students.add(new Student("申恒旭", 21, "男", 98));
        students.add(new Student("刘佳文", 20, "女", 55));
        students.add(new Student("彭佳怡", 23, "女", 68));
    }

    public void printAll() {
        operator.showAll(students);
    }

    public void printAverage() {
        operator.showAverage(students);
    }
}
