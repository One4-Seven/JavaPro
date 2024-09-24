package com.yst.quicksout;

public class Demo {
    public static void main(String[] args) {
        // 认识递归算法 简单的快速排序
        int[] arr = {100, 2, 4, 65, 4, 32, 3, 43, 53, 54, 2542, 3, 534, 453, 45, 234, 3, 213};

        quickSout(arr, 0, arr.length - 1);

        System.out.print("排序后: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quickSout(int[] arr, int i, int j) {
        if (i >= j) return;
        int start = i;
        int end = j;
        int basenumber = arr[start];

        while(start != end) {
            // 先让 end 停在比基准数小得位置
            while(true) {
                if (end <= start || arr[end] < basenumber) break;
                end--;
            }

            // 后让 start 停在比基准数大得位置
            while(true) {
                if (start >= end || arr[start] > basenumber) break;
                start++;
            }

            // 交换 start 和 end 上的数
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
        }

        int temp = arr[end];
        arr[end] = arr[i];
        arr[i] = temp;

        // 递归算法
        quickSout(arr, i, end - 1);
        quickSout(arr, end + 1, j);
    }
}

