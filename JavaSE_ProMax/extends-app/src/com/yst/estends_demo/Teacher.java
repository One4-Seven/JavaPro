package com.yst.estends_demo;

// 继承父类中以 public 关键字修饰的变量和方法
public class Teacher extends People {
    private String skill;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void showSkill() {
        System.out.println(getName() + "老师具有的技能: " + getSkill());
    }
}
