package com.yst.constructor;

public class Demo {
    public static void main(String[] args) {
        // 认识 this() 和 super()
        Student s1 = new Student("杨思婷", 21, "烹饪");
        s1.showInterest();

        Student s2 = new Student("申恒旭", 21);
        s2.showInterest();
    }
}
