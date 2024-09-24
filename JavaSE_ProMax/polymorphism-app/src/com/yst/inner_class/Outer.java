package com.yst.inner_class;

public class Outer {
    public String name = "外部类";
    public static int id = 147;

    // 1. 成员内部类
    public class Inner {
        private String name = "成员内部类";

        public void showName() {
            String name = "内部类方法中的局部变量";
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Outer.this.name);
        }
    }

    // 2.静态内部类
    public static class staticInner {
        private String name = "静态内部类";

        public void showName() {
            System.out.println(name);
        }

        public static void showId() {
            System.out.println("项目ID: " + Outer.id);
        }

    }
}
