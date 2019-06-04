package com.lin.impl;

import com.lin.IMyStack;

/**
 * Description:
 * Author:  llf
 * Created in 2019/5/28 12:33
 */
public class MyStackImpl implements IMyStack {
    private int[] elem;
    private int top;    //保存当前可以存放数组元素得下标
    private int usedSize;
    //默认栈得容量
    private static final int DEFAULE_SIZE=10;

    public MyStackImpl(){
        this.elem=new int[DEFAULE_SIZE];
        this.top=0;
        this.usedSize=0;
    }
    public boolean isFull() {
        return this.top==this.elem.length;
    }

    public void push(int item) {
        if (isFull()) {
            throw new UnsupportedOperationException("栈为满得");
        }
        this.elem[top++]=item;
        this.usedSize++;
    }

    public int pop() {
        if (empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        int data=this.elem[this.top-1];
        --this.top;
        this.usedSize--;
        return data;
    }

    public int peek() {
        if (empty()) {
            throw new UnsupportedOperationException("栈为空");
        }
        return this.elem[top-1];
    }

    public boolean empty() {
        return this.top==0;
    }

    public int size() {
        return this.usedSize;
    }
}
