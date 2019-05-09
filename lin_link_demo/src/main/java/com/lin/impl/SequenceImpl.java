package com.lin.impl;

import com.lin.ISequence;

import java.util.Arrays;

/**
 * Description:顺序表
 * Author:  llf
 * Created in 2019/5/7 12:02
 */
public class SequenceImpl implements ISequence {
    private Object[] elemData;
    private int usedSize;
    public static final int DEFAULT_CAPACITY = 10;

    public SequenceImpl() {
        this.elemData = new Object[DEFAULT_CAPACITY];
        this.usedSize = 0;
    }

    public boolean isFull() {
        return this.usedSize == this.elemData.length;
    }

    public boolean add(int pos, Object data) {
        if (pos < 0 || pos > this.usedSize) {
            return false;
        }
        if (isFull()) {
            this.elemData = Arrays.copyOf(this.elemData,
                    this.elemData.length * 2);
        }
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elemData[i + 1] = this.elemData[i];
        }
        this.elemData[pos] = data;
        this.usedSize++;
        return true;
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    public int search(Object key) {
        if (key == null) {
            throw new UnsupportedOperationException("不可传入null作为参数");
        }
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elemData[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object key) {
        if (key == null) {
            throw new UnsupportedOperationException("不可传入null作为参数");
        }
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elemData[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Object getPos(int pos) {
        if (pos < 0 || pos >= this.usedSize) {
            return null;
        }
        return this.elemData[pos];
    }

    public Object remove(Object key) {
        int index = search(key);
        if (index == -1) {
            return null;
        }
        Object oldData = this.elemData[index];
        int i = 0;
        for (i = index; i < this.usedSize - 1; i++) {
            this.elemData[i] = this.elemData[i + 1];
        }
        this.elemData[i + 1] = null;
        this.usedSize--;
        return oldData;
    }

    public int size() {
        return this.usedSize;
    }

    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elemData[i] + " ");
        }
        System.out.println();
    }

    public void clear() {
        for (int i = 0; i < this.usedSize; i++) {
            this.elemData[i] = null;
        }
        this.usedSize = 0;
    }
}
