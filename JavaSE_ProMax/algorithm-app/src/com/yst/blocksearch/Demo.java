package com.yst.blocksearch;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // 理解认识分块查找算法逻辑
        ArrayList<Block> blocks = new ArrayList<>();

        int[] arr = {1, 3, 6, 7, 18, 23, 35, 20, 22, 36, 40, 56, 50, 76, 66};

        blocks.add(new Block(18,0,4));
        blocks.add(new Block(36,5,9));
        blocks.add(new Block(76,10,14));

        Scanner sc = new Scanner(System.in);
        System.out.print("给出你要查找的数字: ");
        int number = Integer.parseInt(sc.nextLine());

        int index = blockSearch(arr, blocks, number);

        if (index == -1) {
            System.out.print("不存在你要寻找的数!");
        } else {
            System.out.print("你要找的数在数组中的索引: " + index);
        }

    }

    public static int blockSearch(int[] arrs, ArrayList<Block> list, int num) {
         Block block = blockIndex(list, num);

         if (block == null) {
             return -1;
         }

         int startindex = block.getStartIndex();
         int endindex = block.getEndIndex();

         for (int i = startindex; i <= endindex; i++) {
             if (arrs[i] == num) return i;
         }

         return  -1;
    }

    public static Block blockIndex(ArrayList<Block> list, int num) {
        for (Block block : list) {
            if (num < block.getMax()) {
                return block;
            }
        }
        return null;
    }
}
