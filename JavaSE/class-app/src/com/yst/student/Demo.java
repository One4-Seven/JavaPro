package com.yst.student;

public class Demo {
    public static void main(String[] args) {
        // 面向对象编程(oop)
        Student s1 = new Student();
        StudentOperator so1 = new StudentOperator(s1);

        s1.name = "黄海冰";
        s1.age = 21;
        s1.setSex(false);

        s1.setChinese(80);
        so1.showChinese();

        s1.setMath(90);
        so1.showMath();

        s1.setEnglish(100);
        so1.showEnglish();

        s1.setSum();
        so1.showSum();

        s1.setAverage();
        so1.showAverage();

        so1.personalShow();
        so1.speak();

        System.out.println("-------------------------------------");

        Student s2 = new Student("张升源", 21, true);
        StudentOperator so2 = new StudentOperator(s2);

        s2.setSchool("上海复旦大学");

        s2.setChinese(90);
        so2.showChinese();

        s2.setMath(90);
        so2.showMath();

        s2.setEnglish(110);
        so2.showEnglish();

        s2.setEnglish(100);
        so2.showEnglish();

        s2.setSum();
        so2.showSum();

        s2.setAverage();
        so2.showAverage();

        so2.personalShow();
        so2.speak();
    }
}
