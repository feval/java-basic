package com.lin.sort;

/**
 * Description:selectSort
 * Author:  llf
 * Created in 2019/4/25 17:19
 */

/**
 * 选择排序效率太低
 * 时间复杂度:O(N^2)
 * 空间复杂度:O(1)
 * 稳定性:不稳定
 */
public class TestSelectSort {
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j]<array[i]) {
                    int tmp=array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }
}
