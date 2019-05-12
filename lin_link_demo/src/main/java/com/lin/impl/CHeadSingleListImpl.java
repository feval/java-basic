package com.lin.impl;

import com.lin.CLinkList;

/**
 * Description:带头循环单链表
 * Author:  llf
 * Created in 2019/5/9 14:58
 */
public class CHeadSingleListImpl implements CLinkList {
    class Node {
        private int data;
        private Node next;
        public Node() {
            this.data=-1;
        }
        public Node(int data) {
            this.data=data;
        }
    }

    private Node head;
    public CHeadSingleListImpl(){
        this.head=new Node();
        this.head.next=this.head;
    }
    @Override
    public void addFirst(int data) {
        Node node=new Node(data);
        node.next=this.head.next;
        this.head.next=node;
    }

    @Override
    public void addLast(int data) {
        Node cur=this.head;
        while (cur.next!=this.head) {
            cur=cur.next;
        }
        Node node=new Node(data);
        node.next=this.head;
        cur.next=node;
    }

    private void checkIndex(int index) {
        throw new IndexOutOfBoundsException("下标不合法");
    }
    @Override
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        return false;
    }

    @Override
    public boolean contains(int key) {
        return false;
    }

    @Override
    public int remove(int key) {
        return 0;
    }

    @Override
    public void removeAllKey(int key) {

    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public void display() {

    }

    @Override
    public void clear() {

    }
}
