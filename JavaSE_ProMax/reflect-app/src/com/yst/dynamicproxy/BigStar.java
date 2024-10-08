package com.yst.dynamicproxy;

public class BigStar implements Star {
    private String name;

    public BigStar() {
    }

    public BigStar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String  sing(String name) {
        System.out.println(this.name + "喜欢唱" + name);
        return "谢谢大家";
    }

    @Override
    public void dance() {
        System.out.println(this.name + "喜欢跳舞");
    }
}
