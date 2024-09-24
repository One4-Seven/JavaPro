package com.yst.treeset;

public class Teacher implements Comparable<Teacher>{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
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


    @Override
    public int compareTo(Teacher o) {
        int result = this.getAge() - o.getAge();
        result = result == 0 ? this.name.compareTo(o.getName()) : result;
        return result;
    }
}
