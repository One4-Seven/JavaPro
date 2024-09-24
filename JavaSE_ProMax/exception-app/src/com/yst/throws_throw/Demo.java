package com.yst.throws_throw;

public class Demo {
    public static void main(String[] args) {
        // 认识 throws 和 throw 抛出异常
        int[] numbers1 = {};
        int[] numbers2 = null;
        int[] numbers3 = {1, 2, 3, 4, 5};

        try {
            System.out.println(max(numbers1));
        } catch (NullPointerException exception) {
            // 在控制台打印异常信息
            exception.printStackTrace();
            System.out.println("傻逼传个空指针是吧!");
        } catch (ArrayIndexOutOfBoundsException exception) {
            exception.printStackTrace();
            System.out.println("你数组里啥都没有传给我搞鸡毛?");
        }

        try {
            System.out.println(max(numbers2));
        } catch (NullPointerException exception) {
            exception.printStackTrace();
            System.out.println("傻逼传个空指针是吧!");
        } catch (ArrayIndexOutOfBoundsException exception) {
            exception.printStackTrace();
            System.out.println("你数组里啥都没有传给我搞鸡毛?");
        }

        try {
            System.out.println(max(numbers3));
        } catch (NullPointerException exception) {
            exception.printStackTrace();
            System.out.println("傻逼传个空指针是吧!");
        } catch (ArrayIndexOutOfBoundsException exception) {
            exception.printStackTrace();
            System.out.println("你数组里啥都没有传给我搞鸡毛?");
        }
    }

    public static int max(int[] arr) {
        // 抛出异常
        if (arr == null) throw new NullPointerException();
        if (arr.length == 0) throw new ArrayIndexOutOfBoundsException();

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max =arr[i];
        }
        return max;
    }
}
