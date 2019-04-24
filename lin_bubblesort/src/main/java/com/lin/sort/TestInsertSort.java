package com.lin.sort;

/**
 * Description:insertSort
 * Author:  llf
 */

/**
 * 元素越接近有序,效率越高
 * 时间复杂度:O(N^2)
 * 空间复杂度:O(1),
 * 稳定性:稳定
 */

public class TestInsertSort {
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j;
            int tmp = array[i];
            for (j = i - 1; j >= 0; j--) {
                if (tmp<array[j]) {
                    array[j+1]=array[j];
                }else{
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }
}
