package com.yst.student;

// 实体类
public class Student {
    String name;
    int age;
    private boolean sex;
    private String school;
    private double chinese;
    private double math;
    private double english;
    double sum;
    double average;

    // 无参数构造器
    public Student() {
        school = "南京审计大学";
    }

    // 有参数构造器 (this 关键字中存储的是对象在内存中的地址 效果同 Python 关键字 self)
    public Student(String name, int age, boolean sex) {
        school = "南京审计大学";
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void setChinese(double chinese) {
        if (chinese > 0 && chinese <= 100) {
            this.chinese = chinese;
        } else {
            System.out.println("对不起,你录入的语文成绩异常!");
        }
    }

    public double getChinese() {
        return chinese;
    }

    public void setMath(double math) {
        if (math > 0 && math <= 100) {
            this.math = math;
        } else {
            System.out.println("对不起,你录入的数学成绩异常!");
        }
    }

    public double getMath() {
        return math;
    }


    public void setEnglish(double english) {
        if (english > 0 && english <= 100) {
            this.english = english;
        } else {
            System.out.println("对不起,你录入的英语成绩异常!");
        }
    }

    public double getEnglish() {
        return english;
    }


    public void setSchool(String newschool) {
        school = newschool;
    }

    public String getSchool() {
        return school;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSum() {
        sum = chinese + math + english;
    }

    public double getSum() {
        return sum;
    }

    public void setAverage() {
        average = (chinese + math + english) / 3;
    }

    public double getAverage() {
        return average;
    }



}
