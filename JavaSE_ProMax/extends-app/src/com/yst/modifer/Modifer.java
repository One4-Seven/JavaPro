package com.yst.modifer;

public class Modifer {

    // 私有方法 仅能在此类中访问
    private void privateMethod() {
        System.out.println("私有方法");
    }

    // 未修饰方法
    void Method() {
        System.out.println("未修饰方法");
    }

    // 保护方法
    protected void protectedMethod() {
        System.out.println("保护方法");
    }

    // 公开方法 在任意包的任意类中均可以调用
    public void publicMethod() {
        System.out.println("公开方法");
    }

    // 在本类中调用四种方法
    public void textMethod() {
        privateMethod();
        Method();
        protectedMethod();
        publicMethod();
    }
}
