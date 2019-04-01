package com.bit.dao;

import com.bit.dimpl.ILinked;

/**
 *
 */
public class MySingListImpl implements ILinked {

    class Node{
        public int data;
        public Node next;

        public Node(int data) {
            this.data=data;
            this.next=null;
        }
    }
    private Node head;
    public MySingListImpl() {
        this.head=null;
    }
    @Override
    public void addFirst(int data) {
        Node node=new Node(data);
        //第一次插入数据
        if (this.head==null) {
            this.head=node;
        }else {
            node.next = this.head;
            this.head=node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node=new Node(data);
        Node cur=this.head;
        if (cur==null) {
            this.head=node;
        }else {
            while(cur.next!=null) {
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    //找到index-1位置的节点
    private Node searchIndex(int index) {
        checkIndex(index);
        //0
        if (index==0) {
           return null;
        }
        int count=1;   //记录步数
        Node cur=this.head;

        while(cur!=null&&count<index) {
            cur=cur.next;
            count++;
        }
        return cur;
    }

    private void checkIndex(int index) {
        if(index<0||index>getLength()) {
            throw new IndexOutOfBoundsException("下标越界不合法");
        }
    }

    @Override
    public boolean addindex(int index, int data) {
        Node node=new Node(data);
        Node cur=searchIndex(index);
        if(cur==null) {
            node.next=this.head;
            this.head=node;
        }else{
            node.next=cur.next;
            cur.next=node;
        }

        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur=this.head;
        while(cur!=null) {
            if(cur.data==key) {
                return true;
            }
            cur=cur.next;
        }
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
        Node cur=this.head;
        int count=0;
        while(cur!=null) {
            count++;
            cur=cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur=this.head;
        while(cur!=null) {
            System.out.print(cur.data+"  ");
            cur=cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {


    }
}
