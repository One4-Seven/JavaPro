package com.yst.interface_case;

import java.util.ArrayList;

// 接口实现类(impl)
public class OperatorImpl1 implements Operator {
    @Override
    public void showAll(ArrayList<Student> students) {
        System.out.println("----------学 生 信 息----------");
        for (Student student : students) {
            System.out.println("姓名: " + student.getName());
            System.out.println("年龄: " + student.getAge());
            System.out.println("得分: " + student.getScore());
            System.out.println("----------------------------");
        }
    }

    @Override
    public void showAverage(ArrayList<Student> students) {
        double sum = 0;
        for (Student student : students) {
            sum += student.getScore();
        }
        System.out.println("平均得分: " + sum / students.size());
    }
}
