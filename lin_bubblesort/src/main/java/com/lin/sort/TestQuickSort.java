package com.lin.sort;

/**
 * Description:
 * Author:  llf
 * Created in 20 19/4/28 20:06
 */

/**
 * 时间复杂度:O(N*logN)
 * 空间复杂度:O(logN)
 * 稳定性:不稳定
 */
public class TestQuickSort {

    //递归
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    private static void quick(int[] array, int low, int high) {
        if (low == high) {
            return;
        }
        int par = partion(array, low, high);
        if (par > low + 1) {
            quick(array, low, par - 1);
        }
        if (par < high - 1) {
            quick(array, par + 1, high);
        }
    }

    private static int partion(int[] array, int low, int high) {
        int tmp = array[low];
        while (low < high) {
            while (low < high && array[high] >= tmp) {
                high--;
            }
            if (low == high) {
                break;
            } else {
                array[low] = array[high];
            }
            while (low < high && array[low] <= tmp) {
                low++;
            }
            if (low == high) {
                break;
            } else {
                array[high] = array[low];
            }
        }
        array[low] = tmp;
        return low;
    }

    //非递归
    public static void quickSort1(int[] array) {
        int[] stack = new int[array.length * 2];
        int top = 0;
        int low = 0;
        int high = array.length - 1;
        int par = partion(array, low, high);
        if (par > low + 1) {
            stack[top++] = low;
            stack[top++] = par - 1;
        }
        if (par < high - 1) {
            stack[top++] = par + 1;
            stack[top++] = high;
        }
        while (top != 0) {
            high = stack[--top];
            low = stack[--top];
            par = partion(array, low, high);
            if (par > low + 1) {
                stack[top++] = low;
                stack[top++] = par - 1;
            }
            if (par < high - 1) {
                stack[top++] = par + 1;
                stack[top++] = high;
            }
        }
    }

    //优化   三数取中法+插入排序
    public static void quickSort2(int[] array) {
        quick1(array, 0, array.length - 1);
    }
    public static void quick1(int[] array, int low, int high) {
        if (low == high) {
            return;
        }
        if (high - low + 1 <= 10) {
            insertSort(array, low, high);
        }
        takeThreeNumber(array,low,high);
        int par=partion(array,low,high);
        if (par>low+1) {
            quick1(array,low,par-1);
        }
        if (par<high-1) {
            quick1(array,par+1,high);
        }
    }

    private static void takeThreeNumber(int[] array, int low, int high) {
        int mid=(low+high)>>>1;
        if (array[mid]>array[low]) {
            swap(array,low,mid);
        }
        if (array[mid]>array[high]) {
            swap(array,mid,high);
        }
        if (array[low]>array[high]) {
            swap(array,low,high);
        }
    }

    private static void swap(int[] array, int low, int high) {
        int tmp=array[low];
        array[low]=array[high];
        array[high]=tmp;
    }

    private static void insertSort(int[] array, int low, int high) {
        for (int i = low+1; i < high; i++) {
            int j;
            int tmp = array[i];
            for (j = i - 1; j >= low; j--) {
                if (tmp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }
}
