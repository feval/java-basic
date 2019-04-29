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
    public static void quickSort(int[] array) {
        quick(array,0,array.length-1);
    }

    private static void quick(int[] array, int low, int high) {
        if (low==high) {
            return;
        }
        int par=partion(array,low,high);
        if (par>low+1) {
            quick(array,low,par-1);
        }
        if (par<high-1) {
            quick(array,par+1,high);
        }
    }

    private static int partion(int[] array, int low, int high) {
        int tmp=array[low];
        while (low<high) {
            while (low<high&&array[high]>=tmp) {
                high--;
            }
            if (low==high) {
                break;
            }else {
                array[low]=array[high];
            }
            while (low<high&&array[low]<=tmp) {
                low++;
            }
            if (low==high) {
                break;
            }else {
                array[high]=array[low];
            }
        }
        array[low]=tmp;
        return low;
    }
}
