package com.yst.generic_class;

public class Demo {
    public static void main(String[] args) {
        // 认识泛型类的基本使用方法
        MyList1<String> list1 = new MyList1<>();
        list1.add("Java");
        list1.add("Python");
        list1.add("C++");
        System.out.println(list1.get(1));

        // 定义多泛型
        MyList2<String, Cat> list2 = new MyList2<>();
        list2.put("哈哈哈", new Cat());

        // 限定泛型条件
        MyList3<Cat> list3 = new MyList3<>();
        list3.put(new Cat());
    }
}
