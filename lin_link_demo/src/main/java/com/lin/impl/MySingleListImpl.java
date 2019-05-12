package com.lin.impl;

import com.lin.ILinked;

/**
 * Description:无头单向非循环链表
 * Author:  llf
 * Created in 2019/5/7 13:27
 */
public class MySingleListImpl implements ILinked {
    public class Node {
        private int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }
    private Node head;

    public MySingleListImpl() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    @Override
    public void addFirst(int data) {
        Node node=new Node(data);
        if (this.head==null) {
            this.head=node;
        }else {
            node.next=this.head;
            this.head=node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node=new Node(data);
        Node cur=this.head;
        if (this.head==null) {
            this.head=node;
        }else {
            while (cur.next!=null) {
                cur=cur.next;
            }
            cur.next=node;
        }
    }


    @Override
    public boolean addIndex(int index, int data) {
      Node node=new Node(data);
      Node cur=searchIndex(index);
      if (cur==null) {
          node.next=this.head;
          this.head=node;
      }else {
          node.next=cur.next;
          cur.next=node;
      }
        return true;
    }
   //找到index的前一个节点
    private Node searchIndex(int index) {
        checkIndex(index);
        if (index==0) {
            return null;
        }
        int count=0;
        Node cur=this.head;
        while (cur.next!=null&&count<index-1) {
            cur=cur.next;
            count++;
        }
        return cur;
    }


    public void checkIndex(int index){
        if (index<0||index>getLength()) {
            throw new IndexOutOfBoundsException("链表下标越界");
        }
    }

    @Override
    public boolean contains(int key) {
        Node cur=this.head;
        while (cur!=null){
            if (cur.data==key) {
                return true;
            }
            cur=cur.next;
        }
         return false;
    }

    @Override
    public int remove(int key) {
        int oldData=0;
        Node pre=searchPre(key);
        if (pre==null) {
            throw new UnsupportedOperationException("没有key的前驱");
        }
        if (pre==this.head&&pre.data==key) {
            oldData=this.head.data;
            this.head=this.head.next;
            return oldData;
        }
        oldData=pre.next.data;
        Node delNode=pre.next;
        pre.next=delNode.next;
        return oldData;
    }

    private Node searchPre(int key) {
        Node pre=this.head;
        if (pre.data==key) {
            return this.head;
        }
        while (pre.next!=null) {
            if (pre.next.data==key) {
                return pre;
            }
            pre=pre.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(int key) {
        Node pre=this.head;
        Node cur=this.head.next;
        while (cur.next!=null) {
            if (cur.next.data==key) {
                pre.next=cur.next;
                cur=cur.next;
            }else {
                pre=cur;
                cur=cur.next;
            }
        }
        if (this.head.data==key) {
            this.head=this.head.next;
        }
    }

    @Override
    public int getLength() {
        Node cur =this.head;
        int count=0;
        while (cur.next!=null) {
            cur=cur.next;
            count++;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur=this.head;
        while (cur!=null) {
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while (this.head!=null) {
            Node cur=this.head.next;
            this.head.next=null;
            this.head=cur;
        }
    }


    public void show(Node newHead) {
        Node cur=newHead;
        while (cur!=null) {
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
}
