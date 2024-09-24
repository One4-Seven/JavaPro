package com.yst.override;

public class Demo {
    public static void main(String[] args) {
        // 认识简单的方法重写 默认所有类继承 Object
        // 重写父类中的方法 方法名和参数列表要相同
        // 重写方法的访问权限大于等于父类 public > protected > 省略 > private
        // 重写后方法的返回值与父类相同或者范围更小
        // 私有方法和静态方法不可以被重写
        Father fa = new Father();
        fa.speak();

        Son so = new Son();
        so.speak();

        // super 关键字调用父类方法
        so.speaks();

        System.out.println(fa.toString());
        System.out.println(so.toString());
    }
}
