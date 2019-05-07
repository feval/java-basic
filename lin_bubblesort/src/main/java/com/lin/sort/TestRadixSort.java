package com.lin.sort;

/**
 * Description:
 * Author:  llf
 */

/**
 * 非比较排序
 * 稳定性:稳定
 */
public class TestRadixSort {
    public static void radixSort(int[] array) {
        if (array.length<=1) {
            return;
        }
        int max=0;
        for (int i = 0; i < array.length; i++) {
            if (max<array[i]) {
                max=array[i];
            }
        }
        int maxDoght=1;
        while (max/10>0) {
            maxDoght++;
            max=max/10;
        }
        int[][] buckets=new int[10][array.length];
        int base=10;
        for (int i = 0; i < maxDoght; i++) {
            int[] bktlen=new int[10];
            for (int j = 0; j < array.length; j++) {
                int whichBucket=array[j]%base/(base/10);
                buckets[whichBucket][bktlen[whichBucket]]=array[j];
                bktlen[whichBucket]++;
            }
            int k=0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktlen[b]; p++) {
                    array[k++]=buckets[b][p];
                }
            }
            base*=10;
        }
    }
}
