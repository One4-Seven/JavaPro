package com.yst.constructor;

class F {
    protected String name;
    public F() {
        System.out.println("父类的无参构造器执行!");
    }

    public F(String neme) {
        this.name = neme;
        System.out.println("父类的有参构造器执行!");
    }
}

class S extends F {
    public S() {
        // 调用父类无参构造器
        super();
        System.out.println("子类的无参构造器执行!");
    }

    public S(String name) {
        // 调用父类有参构造器
        super(name);
        System.out.println("子类的有参构造器执行!");
    }

}
public class Constructor {
    public static void main(String[] args) {
        // 子类构造器执行默认优先执行父类无参构造器
        F father1 = new F();
        father1.name = "申恒旭";
        System.out.println("大爸爸: " + father1.name);

        F father2 = new F("申恒旭");
        System.out.println("二爸爸: " + father2.name);

        S son1 = new S();
        son1.name = "黄海冰";
        System.out.println("大儿子: " + son1.name);

        S son2 = new S("张升源");
        System.out.println("二儿子: " + son2.name);
    }
}
