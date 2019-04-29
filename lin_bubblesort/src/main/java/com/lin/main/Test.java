package com.lin.main;

import com.lin.sort.*;

import java.util.Arrays;

/**
 * Description:
 * Author:  llf
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

    public static void main2(String[] args) {
        int[] array=new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i]=1000-i;
        }
        long start = System.nanoTime();
        TestInsertSort.insertSort(array);
        long end = System.nanoTime();
        System.out.println(Arrays.toString(array));
        System.out.println(end-start);
    }

    public static void main3(String[] args) {
        int[] array=new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i]=1000-i;
        }
        long start = System.nanoTime();
        TestShellSort.shellSort(array);
        long end = System.nanoTime();
        System.out.println(Arrays.toString(array));
        System.out.println(end-start);
    }

    public static void main4(String[] args) {
        int[] array=new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i]=1000-i;
        }
        long start = System.nanoTime();
        TestSelectSort.selectSort(array);
        long end = System.nanoTime();
        System.out.println(Arrays.toString(array));
        System.out.println(end-start);
    }
    public static void main5(String[] args) {
        int[] array=new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i]=1000-i;
        }
        long start = System.nanoTime();
        TestHeapSort.heapSort(array);
        long end = System.nanoTime();
        System.out.println(Arrays.toString(array));
        System.out.println(end-start);
    }
    public static void main(String[] args) {
        int[] array=new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i]=1000-i;
        }
        long start = System.nanoTime();
        TestQuickSort.quickSort(array);
        long end = System.nanoTime();
        System.out.println(Arrays.toString(array));
        System.out.println(end-start);
    }
}
