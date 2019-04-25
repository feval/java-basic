package com.lin.sort;

/**
 * Description:shellSort
 * Author:  llf
 */

/**
 * 希尔排序是对直接插入排序的优化
 * 本质:使数组越接近有序,提高插入排序的效率,但在传入最后的组数据必须等于1
 * 平均时间复杂度:O(N^1.3-N^2)
 * 稳定性,不稳定
 */

public class TestShellSort {
    public static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int j;
            int tmp = array[i];
            for (j = i - gap; j >= 0; j -= gap) {
                if (tmp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j+gap]=tmp;
        }
    }
    public static void shellSort(int[] array) {
        int[] drr={5,2,1};
        for (int i = 0; i <drr.length ; i++) {
            shell(array,drr[i]);
        }
    }
}
