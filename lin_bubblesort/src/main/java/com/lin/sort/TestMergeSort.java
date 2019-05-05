package com.lin.sort;

/**
 * Description:
 * Author:  llf
 * Created in 2019/5/3 23:36
 */
public class TestMergeSort {
    public static void mergeSort(int[] array) {
        for (int i = 1; i < array.length; i=i*2) {
            merge(array, i);
        }
    }

    private static void merge(int[] array, int gap) {
        int[] tmpArray = new int[array.length];
        int i = 0;                 //存放排序后的数组     i为数组下标

        int start1 = 0;
        int end1 = start1 + gap - 1;
        int start2 = end1 + 1;
        int end2 = start2 + gap - 1 > array.length - 1 ? array.length - 1 : start2 + gap - 1;

        while (start2 < array.length) {
            while (start1 <= end1 && start2 <= end2) {
                if (array[start1] <= array[start2]) {
                    tmpArray[i++] = array[start1++];
                } else {
                    tmpArray[i++] = array[start2++];
                }
            }
            while (start1 <= end1) {
                tmpArray[i++] = array[start1++];
            }
            while (start2 <= end2) {
                tmpArray[i++] = array[start2++];
            }

            start1 = end2 + 1;
            end1 = start1 + gap - 1;
            start2 = end1 + 1;
            end2 = start2 + gap - 1 > array.length - 1 ? array.length - 1 : start2 + gap - 1;
        }
        while (start1<=array.length-1) {
            tmpArray[i++]=array[start1++];
        }
        for (int j = 0; j < tmpArray.length; j++) {
            array[j]=tmpArray[j];
        }
    }
}
