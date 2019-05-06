package com.lin.sort;

import java.util.Arrays;

/**
 * Description:
 * Author:  llf
 * Created in 2019/5/3 23:36
 */

/**
 * 归并排序的缺点在于需要O(N)的空间复杂度,
 * 归并排序的思考更多的使解决磁盘中的排序问题
 * 时间复杂度:O(N*logN)
 * 空间复杂度:O(N)
 * 稳定性:稳定
 */
public class TestMergeSort {
    public static void mergeSort(int[] array) {
        for (int i = 1; i < array.length; i = i * 2) {
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
        while (start1 <= array.length - 1) {
            tmpArray[i++] = array[start1++];
        }
        for (int j = 0; j < tmpArray.length; j++) {
            array[j] = tmpArray[j];
        }
    }

    //递归实现
    public static void mergeSort1(int[] array) {
        mergeSort1(array, 0, array.length - 1);
    }

    private static void mergeSort1(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >>> 1;
        mergeSort1(array, start, mid);
        mergeSort1(array, mid + 1, end);
        merge1(array, start, mid, end);
    }

    private static void merge1(int[] array, int start, int mid, int end) {
        int[] tmpArr = new int[array.length];
        int tmpIndex = start;     //存放排序后的数组     tmpIndex为数组下标

        int start2 = mid + 1;
        int i = start;

        while (start <= mid && start2 <= end) {
            if (array[start] <= array[start2]) {
                tmpArr[tmpIndex++] = array[start++];
            } else {
                tmpArr[tmpIndex++] = array[start2++];
            }
        }
        while (start <= mid) {
            tmpArr[tmpIndex++] = array[start++];
        }
        while (start2 <= end) {
            tmpArr[tmpIndex++] = array[start2++];
        }
        while (i <= end) {
            array[i] = tmpArr[i];
            i++;
        }
    }
}
