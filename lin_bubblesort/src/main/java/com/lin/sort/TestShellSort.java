package com.lin.sort;

/**
 * Description:
 * Author:  llf
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
