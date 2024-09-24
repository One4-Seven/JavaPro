package com.yst.interface_case;

import java.util.ArrayList;

// 接口实现类(impl)
public class OperatorImpl2 implements Operator {
    @Override
    public void showAll(ArrayList<Student> students) {
        int count1 = 0;
        int count2 = 0;
        System.out.println("----------学 生 信 息----------");
        for (Student student : students) {
            System.out.println("姓名: " + student.getName());
            System.out.println("性别: " + student.getSex());
            if (student.getSex().equals("男")) {
                count1++;
            } else {
                count2++;
            }
            System.out.println("得分: " + student.getScore());
            System.out.println("----------------------------");
        }
        System.out.println("班级男生人数: " + count1 + " 班级女生人数: " + count2);
    }

    @Override
    public void showAverage(ArrayList<Student> students) {
        double sum = 0;
        double max = students.getFirst().getScore();
        double min = students.getFirst().getScore();
        for (Student student : students) {
            if (student.getScore() > max) max = student.getScore();
            if (student.getScore() < min) min = student.getScore();
            sum += student.getScore();
        }
        sum = sum - max - min;
        System.out.println("班级最高分: " + max + " 班级最低分: " + min);
        System.out.println("去除最高(低)分后的平均得分: " + sum / (students.size() - 2));
    }
}
