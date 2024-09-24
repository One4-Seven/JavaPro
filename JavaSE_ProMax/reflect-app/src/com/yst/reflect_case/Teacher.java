package com.yst.reflect_case;

public class Teacher {
    private String name;
    private int age;
    private String gender;
    private String info;

    public Teacher() {
    }

    public Teacher(String name, int age, String gender, String info) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
