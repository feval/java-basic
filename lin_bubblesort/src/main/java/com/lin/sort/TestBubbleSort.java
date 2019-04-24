package com.lin.sort;

/**
 * Description:bubblerSort
 * Author:  llf
 */

/**
 * 冒泡排序的优化:在第一次循环中若未发生交换,则该数组本来就有序
 * 时间复杂度:O(N^2)
 * 空间复杂度:O(1)
 * 稳定性:稳定
 */

public class TestBubbleSort {
    public static void bubblerSort(int[] array) {
        for (int i = 0; i <array.length ; i++) {
            boolean swap =false;
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j]>array[j+1]) {
                    int tmp =array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    swap=true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }
}
