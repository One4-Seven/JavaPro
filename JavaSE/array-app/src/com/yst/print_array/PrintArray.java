package com.yst.print_array;

public class PrintArray {
    public static void main(String[] args) {
        // 打印数组
        int[] arr1 = null;
        int[] arr2 = {11, 22, 33, 44, 55};

        printarray(arr1);
        printarray(arr2);
    }

    public static void printarray(int[] arr) {
        // 优先判断列表是否存在
        if (arr == null) {
            System.out.println("不是哥们,你就拿空指针考验兄弟们?");
            return;
        }

        System.out.print('[');
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print(']');
    }
}
