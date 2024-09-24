package com.yst.compare_array;

public class CompareArray {
    public static void main(String[] args) {
        // 比较两个数组是否相同
        int[] arr1 = null;
        int[] arr2 = null;
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {1, 2, 3, 4};
        int[] arr5 = {1, 2, 3, 4};

        comparearray(arr1, arr2);
        comparearray(arr2, arr3);
        comparearray(arr3, arr4);
        comparearray(arr4, arr5);
    }

    public static void comparearray(int[] arr1, int[] arr2) {
        // 两个空指针
        if(arr1 == null && arr2 == null) {
            System.out.println("两个空指针还能不相等?");
            return;
        }

        // 存在一个空指针
        if(arr1 == null || arr2 == null) {
            System.out.println("一虚一实你也分不清是吧?");
            return;
        }

        // 两个列表长度不同
        if(arr1.length != arr2.length) {
            System.out.println("两个都不一样长,搞笑呢哥们?");
            return;
        }

        // 对比每一个位置的元素
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                System.out.println("不一样哦,宝贝~");
                return;
            }
        }

        System.out.println("不吹不黑,一毛一样!");
    }
}
