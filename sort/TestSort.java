package sort;

import java.util.Arrays;

/**
 *
 */
public class TestSort {
    public static void main(String[] args) {

        int[] array = new int[]{5, 4, 6, 2, 3, 9, 8};
        selectSort(array);
        heapSort(array);
        quickSort(array);
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int j;
            int tmp = array[i];
            for (j = i - 1; j >= 0; j--) {
                if (tmp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }


    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }


    public static void adjust(int[] array, int start, int end) {
        int tmp = array[start];
        for (int i = 2 * start + 1; i <= end; i = 2 * i + 1) {
            if (i < end && array[i] < array[i + 1]) {
                i++;
            }
            if (array[i] > tmp) {
                array[start] = array[i];
                start = i;
            } else if (array[i] < tmp) {
                break;
            }
        }
        array[start] = tmp;
    }

    public static void heapSort(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            adjust(array, i, array.length - 1);
        }
        for (int j = 0; j <= array.length - 1; j++) {
            int tmp = array[0];
            array[0] = array[array.length - 1 - j];
            array[array.length - 1 - j] = tmp;
            adjust(array, 0, array.length - 1 - j - 1);
        }
    }


    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    public static void quick(int[] array, int low, int high) {
        if (low == high) {
            return;
        }
        //
        //
        //

        int par = partion(array, low, high);
        if (par > low + 1) {
            quick(array, low, par - 1);
        }
        if (par < high - 1) {
            quick(array, par + 1, high);
        }
    }

    public static int partion(int[] array, int low, int high) {

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
            stack[--top] = high;
            stack[--top] = low;
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


    public static void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >>> 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int[] tmpArr = new int[array.length];
        int tmpIndex = start;
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

    public static void mergeSort1(int[] array) {
        for (int i = 0; i <array.length ; i++) {
            merge1(array,i);
        }
    }
    public static void merge1(int[] array, int gap) {

    }


    public static void bubblerSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swap=false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j]>array[j+1]) {
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    swap=true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }
}
