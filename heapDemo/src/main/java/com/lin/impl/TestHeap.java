package com.lin.impl;

import com.lin.IHeap;

import java.util.Arrays;

/**
 * Description:
 * Author:  llf
 * Created in 2019/7/26 16:12
 */
public class TestHeap implements IHeap {
    private int[] elem;
    private  int usedSize;
    private final int DEFAULT_SIZE=10;

    public TestHeap() {
        this.usedSize=0;
        this.elem=new int[DEFAULT_SIZE];
    }

    public void adjustDown(int root, int len) {
        int parsent=root;
        int child=2*parsent+1;
        while (child<len) {
            if (child+1<len&&this.elem[child]<this.elem[child+1]) {
                child++;
            }
            if (this.elem[parsent]<this.elem[child]) {
                int tmp = elem[child];
                elem[child] = elem[parsent];
                elem[parsent] = tmp;
                parsent=child;

                child=2*parsent+1;
            }else {
                break;
            }
        }
    }

    public void initHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i]=array[i];
            this.usedSize++;
        }
        for (int i = (elem.length-1-1)/2; i >=0; i--) {
            adjustDown(i,this.usedSize);
        }
    }

    public void adjustUp(int child) {
        int parsent=(child-1)/2;
        while (child>0) {
            if (this.elem[parsent]<this.elem[child]) {
                int tmp = elem[child];
                elem[child] = elem[parsent];
                elem[parsent] = tmp;
                child=parsent;
                parsent=(child-1)/2;
            }else {
                break;
            }
        }

    }

    public boolean isFull() {
        if (this.usedSize==this.elem.length) {
            return true;
        }
        return false;
    }
    public void pushHeap(int item) {
        if (isFull()) {
            this.elem= Arrays.copyOf(this.elem,
                    2*this.elem.length);
        }
        this.elem[this.usedSize]=item;
        this.usedSize++;
        adjustUp(this.usedSize-1);
    }

    public int popHeap() {
        if (this.usedSize==0) {
            throw new UnsupportedOperationException("堆为空");
        }
        int tmp = elem[0];
        elem[0] = elem[this.usedSize-1];
        elem[this.usedSize-1] = tmp;
        this.usedSize--;
        adjustDown(0,this.usedSize);
        return elem[usedSize];
    }

    public int getHeapTop() {
        if (this.usedSize==0) {
            throw new UnsupportedOperationException("堆为空");
        }
        return this.elem[0];
    }

    public void HeapSort() {
        int end=this.usedSize-1;
        while (end>0) {
            int tmp = elem[0];
            elem[0] = elem[end];
            elem[end] = tmp;
            adjustDown(0,end);
            end--;
        }
    }

    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
}
