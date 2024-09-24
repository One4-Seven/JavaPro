package com.yst.estends_demo;

public class ExtendsDemo {
    public static void main(String[] args) {
        // 认识基本的继承属性 默认继承 Object 类(祖宗类)
        Teacher t1 = new Teacher();
        Teacher t2 = new Teacher();
        t1.setName("杨永信");
        t2.setName("盛虹");
        t1.setSkill("Java, Python");
        t2.setSkill("C++, C#, C语言");
        t1.showSkill();
        t2.showSkill();
    }
}
