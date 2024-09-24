package com.yst.student;

// 操作类
public class StudentOperator {
    private Student student;

    public StudentOperator(Student student) {
        this.student = student;
    }

    public void showChinese() {
        System.out.println(student.name + "的语文成绩: " + student.getChinese());
    }

    public void showMath() {
        System.out.println(student.name + "的数学成绩: " + student.getMath());
    }

    public void showEnglish() {
        System.out.println(student.name + "的英语成绩: " + student.getEnglish());
    }

    public void showSum() {
        System.out.println(student.name + "的三科总分是: " + student.getSum());
    }

    public void showAverage() {
        System.out  .println(student.name + "的三科平均分是: " + student.getAverage());
    }

    public void personalShow() {
        if (student.getSex()) {
            System.out.println("我是来自" + student.getSchool() + "的" + student.name + ",很高兴认识大家!" );
            System.out.println("(芳龄" + student.age + "的强壮雄性生物!)");
        } else {
            System.out.println("我是来自" + student.getSchool() + "的" + student.name + ",很高兴认识大家!" );
            System.out.println("(芳龄" + student.age + "的温婉雌性生物!)");
        }

    }

    public void speak() {
        System.out.println("我爱上学!");
    }

}
