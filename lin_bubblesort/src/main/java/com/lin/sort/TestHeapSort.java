package com.lin.sort;

/**
 * Description:
 * Author:  llf
 * Created in 2019/4/26 19:37
 */
public class TestHeapSort {
    public static void heapSort(int[] array) {
        for (int i = (array.length - 1 - 1 / 2); i > 0; i--) {
            adjustDown(array, i, array.length - 1);
        }
        for (int j = 0; j < array.length - 1; j++) {
            int tmp =array[0];
            array[0]=array[array.length-1-j];
            array[array.length-1-j]=tmp;
            adjustDown(array,0,array.length-1-j-1);
        }
    }

    private static void adjustDown(int[] array, int start, int end) {
        int tmp = array[start];
        for (int i = 2 * start + 1; i <= end; i=2*i+1) {
            if ((i<end)&&array[i]<array[i+1]) {
                i++;
            }
            if (array[i]>tmp) {
                array[start]=array[i];
                start=i;
            }else if (array[i]<tmp) {
                break;
            }
        }
        array[start]=tmp;
    }
}
