package com.yst.constructor;

public class Student extends People {
    private String interest;

    public Student(String name, int age) {
        // 兄弟构造器 调用自身的构造器
        this(name, age, "打胶");
    }

    public Student(String name, int age, String interest) {
        super(name, age);
        this.interest = interest;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public void showInterest() {
        System.out.println(getName() + "的兴趣爱好是: " + getInterest());
    }
}
