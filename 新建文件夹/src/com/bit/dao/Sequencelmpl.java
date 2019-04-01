package com.bit.dao;

import com.bit.dimpl.ISequence;

import java.util.Arrays;

/**
 *
 */
public class Sequencelmpl implements ISequence {
    private  Object[] elemdata;
    private  int usedSize;
    public static final int DEFAULT_CAPACITY=10;

    public Sequencelmpl() {
        this.elemdata=new Object[DEFAULT_CAPACITY];
        this.usedSize=0;
    }
    //判断是否为满
    public boolean isFull() {
        return  this.usedSize==this.elemdata.length;
    }
    @Override
    public boolean add(int pos, Object data) {
        //1.判断pos的合法性,放入数据后是否会发生溢出
        if(pos<0||pos>this.usedSize) {
            return false;
        }
        //扩容
        if(isFull()) {
            this.elemdata=Arrays.copyOf(this.elemdata,this.elemdata.length*2);
        }
        //2.挪数据
        for (int i = this.usedSize-1; i >pos ; i--) {
            this.elemdata[i+1]=this.elemdata[i];
        }
        //放入数据  usedSize++
        this.elemdata[pos]=data;
        this.usedSize++;
        return true;
    }

    private boolean isEmpty() {
        return this.usedSize==0;
    }

    @Override
    public int search(Object key) {
        if(key==null) {
            throw new UnsupportedOperationException("不可以传"+"null作为参数");
        }
        if(isFull()) {
            return -1;
        }
        for (int i = 0; i <this.usedSize ; i++) {
            if(this.elemdata.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean cotain(Object key) {
        if(key==null) {
            throw new UnsupportedOperationException("不可以传"+"null作为参数");
        }
        if(isFull()) {
            return false;
        }
        for (int i = 0; i <this.usedSize ; i++) {
            if(this.elemdata.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if(pos<0||pos>=this.usedSize) {
            return null;
        }
        return this.elemdata[pos];
    }

    @Override
    public Object remove(Object key) {
        int index=search(key);
        if (index==-1) {
            return null;
        }
        Object oidData=this.elemdata[index];
        int i=0;
        for (i = index; i <this.usedSize-1 ; i++) {
            this.elemdata[i]=this.elemdata[i+1];
        }
        this.elemdata[i+1]=null;
        this.usedSize--;
        return oidData;
    }


    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.print(this.elemdata[i]+" ");
        }
        System.out.println();

    }

    @Override
    public void clear() {
        for (int i = 0; i <this.usedSize ; i++) {
            this.elemdata[i]=null;
        }
        this.usedSize=0;
    }
}
