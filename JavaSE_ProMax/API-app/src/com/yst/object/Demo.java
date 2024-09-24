package com.yst.object;

public class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 认识基本的 Object 类中的方法

        // toString 方法
        Student s1 = new Student("申恒旭", 21);
        Student s2 = new Student("杨思婷", 21);
        Teacher t1 = new Teacher("刘佳文", 25);
        Teacher t2 = new Teacher("彭佳怡", 27);
        Teacher t3 = new Teacher("彭佳怡", 27);

        // 未重写的 toString 方法默认返回地址
        String str1 = s1.toString();
        System.out.println(str1);

        // 重写后会调用新的 toString 方法
        String str2 = t1.toString();
        System.out.println(str2);

        // println 方法会默认调用 toString 方法
        System.out.println(s1);
        System.out.println(t1);

        // equals 方法
        // 未重写的 equals 方法默认比较地址 返回值为布尔类型
        if (s1.equals(s2)) {
            System.out.println("s1 和 s2 的地址相同");
        } else {
            System.out.println("s1 和 s2 的地址不同");
        }

        // 重写后会调用新的 equals 方法
        if (t1.equals(t2)) {
            System.out.println("t1 和 t2 的内容相同");
        } else {
            System.out.println("t1 和 t2 的内容不同");
        }

        if (t2.equals(t3)) {
            System.out.println("t2 和 t3 的内容相同");
        } else {
            System.out.println("t2 和 t3 的内容不同");
        }

        // 面试题考察 对于 equals 方法的认识和比较
        String s = "abc";
        StringBuilder sb = new StringBuilder("abc");

        // String 类中重写了 equal 方法
        // 所以第一种情况下查看重写的 equals 方法
        // 字符串调用 equals 方法优先比较是否为字符串类型 然后比较内容 所以的一种方法返回 false
        System.out.println(s.equals(sb));

        // StringBuilder 类中没有重写 equals 方法
        // 所以第二种情况下参考 Object 类中的 equals 方法
        // 直接比较两者的地址是否相同 所以第二种方法返回值也是 false
        System.out.println(sb.equals(s));

        // clone 方法
        // 默认为浅克隆(存在数组时直接把地址复制给新对象 指向同一数组) 返回值为 Object 类需要强转
        Student s3 = (Student) s2.clone();
        Teacher t4 = (Teacher) t1.clone();

        System.out.println(s3);
        System.out.println(t4);

        // 验证浅克隆
        Scores sc1 = new Scores(new int[]{1, 2, 3, 4, 5});
        Scores sc2 = (Scores) sc1.clone();

        // 修改克隆数组的值
        sc2.getScores()[0] = 100;

        // 检查两个数组内容
        System.out.println(sc1);
        System.out.println(sc2);
    }
}
