package com.lin.main;

import com.lin.sort.TestBubbleSort;
import com.lin.sort.TestInsertSort;

import java.util.Arrays;

/**
 * Description:
 * Author:  llf
 * Created in 2019/7/27 15:28
 */
public class Test {
    public static void main1(String[] args) {
        int[] array=new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i]=1000-i;
        }
        TestBubbleSort.bubblerSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array=new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i]=1000-i;
        }
        TestInsertSort.insertSort(array);
        System.out.println(Arrays.toString(array));
    }


}
