package com.lin.impl;

import com.lin.IMyQueue;

/**
 * Description:
 * Author:  llf
 * Created in 2019/5/28 12:33
 */
public class MyQueueImpl implements IMyQueue {
    class Node{
        private int data;
        private Node next;
        public Node(int data) {
            this.data=data;
        }
    }
    private Node front;
    private Node rear;
    private int usedSize;
    public MyQueueImpl() {
        this.rear=null;
        this.front=null;
        this.usedSize=0;
    }
    public boolean empty() {
        return this.usedSize==0;
    }

    public int peek() {
        if (empty()) {
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }

    public int poll() {
        if (empty()) {
            throw new UnsupportedOperationException("队列为空");
        }
        int data=this.front.data;
        this.front=this.front.next;
        this.usedSize--;
        return data;
    }

    public void add(int item) {
        if (empty()) {
            this.front=new Node(item);
            this.rear=this.front;
        }else {
            this.rear.next=new Node(item);
            this.rear=this.rear.next;
        }
        this.usedSize++;
    }

    public int size() {
        return this.usedSize;
    }
}
