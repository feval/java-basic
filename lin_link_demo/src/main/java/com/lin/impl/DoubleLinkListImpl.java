package com.lin.impl;

import com.lin.IDoubleLinked;

import javax.naming.ldap.PagedResultsControl;
import java.beans.IndexedPropertyDescriptor;

/**
 * Description:不带头双向链表实现
 * Author:  llf
 * Created in 2019/5/25 11:24
 */
public class DoubleLinkListImpl implements IDoubleLinked {
    class Node {
        private int data;
        private Node prev;
        private Node next;

        public Node(int data) {
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    private Node head;
    private  Node last;
    public DoubleLinkListImpl() {
        this.head=null;
        this.last=null;
    }
    @Override
    public void addFirst(int data) {
        //第一次插入
        Node node= new Node(data);
        if (this.head==null) {
            this.head=node;
            this.last=node;
        }else {
            node.next=this.head;
            node.next.prev=node;
            this.head=node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node =new Node(data);
        if (this.head==null) {
            this.head=null;
            this.last=null;
        }else {
            this.last.next=node;
            node.prev=this.last;
            this.last=node;
        }
    }

    @Override
    public boolean addIndex(int index, int data) {
        if (index==0) {
            addFirst(data);
            return true;
        }
        if (index==getLength()) {
            addLast(data);
            return true;
        }
        Node node=new Node(data);
        Node cur=searchIndex(index);
        node.next=cur;
        cur.prev.next=node;
        node.prev=cur.prev;
        cur.prev=node;
        return true;
    }

    private Node searchIndex(int index) {
        checkIndex(index);
        Node cur =this.head;
        int count=0;
        while (count<index) {
            cur=cur.next;
            count++;
        }
        return cur;
    }

    private void checkIndex(int index) {
        if (index<0||index>getLength()) {
            throw new IndexOutOfBoundsException("下标不合法");
        }
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
