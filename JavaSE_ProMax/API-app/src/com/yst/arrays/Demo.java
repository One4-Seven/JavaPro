package com.yst.arrays;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        // 认识基本的 Arrays 方法
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 以字符串方式返回数组
        System.out.println(Arrays.toString(arr1));

        // 拷贝数组
        int[] arr2 = Arrays.copyOf(arr1, 8);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = Arrays.copyOf(arr1, 12);
        System.out.println(Arrays.toString(arr3));

        // 拷贝数组 设置拷贝范围 包左不包右
        int[] arr4 = Arrays.copyOfRange(arr1, 0, 9);
        System.out.println(Arrays.toString(arr4));
        int[] arr5 = Arrays.copyOfRange(arr1, 2, 7);
        System.out.println(Arrays.toString(arr5));


        // 查找数组
        // 如果存在则返回索引 不存在返回应在索引的相反数减一
        int index1 = Arrays.binarySearch(arr1, 10);
        System.out.println(index1);
        int index2 = Arrays.binarySearch(arr1, 11);
        System.out.println(index2);

        // 填充数组
        int[] arr6 = {1, 1, 1, 1, 11, 1, 1};
        Arrays.fill(arr6, 100);
        System.out.println(Arrays.toString(arr6));

        // 数组排序 默认升序 底层采用插入排序加二分查找实现
        int[] arr7 = {2, 5, 3, 4, 7, 10, 19, 10, 2, 8};
        Arrays.sort(arr7);
        System.out.println(Arrays.toString(arr7));

        // 使用 lambda 表达式重写 sort 方法中的 Comparator 接口中的 compare 方法来实现自定义排序方法
        // compare 方法实质上就是一种排序规则 由我们自己来实现
        // Comparator 接口中的 compare 方法有两个泛型数字的形参
        // o1 代表无序序列中从第二个起的每一个元素 o2 代表有序部分的元素
        // 每次会返回一个 int 类型的值
        // -1 代表会把无需序列的值插入到当前比较对象的前面
        // 1 代表会把无需序列的值插入到当前比较对象的后面
        // 0 代表会把无需序列的值插入到当前比较对象的后面

        GirlFriend girl1 = new GirlFriend("yangsiting", 21, 1.65);
        GirlFriend girl2 = new GirlFriend("liujiawen", 23, 1.74);
        GirlFriend girl3 = new GirlFriend("pengjaiyi", 22, 1.7);

        GirlFriend[] girlFriends = {girl1, girl2, girl3};

        // 按照 年龄 身高 首字母 进行升序排序
        // 传参数多传递一个比较器对象进行自定义排序
        Arrays.sort(girlFriends, (o1, o2) -> {
                double temp = o1.getAge() - o2.getAge();
                temp = temp == 0 ? o1.getHeight() - o2.getHeight() : temp;
                temp = temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;
                if (temp > 0) return 1;
                if (temp < 0) return -1;
                return 0;
            });

        for (GirlFriend girlFriend : girlFriends) {
            System.out.println(girlFriend);
        }
    }
}
