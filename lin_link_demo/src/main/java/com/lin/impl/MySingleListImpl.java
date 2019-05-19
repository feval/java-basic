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
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }


    @Override
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        Node cur = searchIndex(index);
        if (cur == null) {
            node.next = this.head;
            this.head = node;
        } else {
            node.next = cur.next;
            cur.next = node;
        }
        return true;
    }

    //找到index的前一个节点
    private Node searchIndex(int index) {
        checkIndex(index);
        if (index == 0) {
            return null;
        }
        int count = 0;
        Node cur = this.head;
        while (cur.next != null && count < index - 1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }


    public void checkIndex(int index) {
        if (index < 0 || index > getLength()) {
            throw new IndexOutOfBoundsException("链表下标越界");
        }
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        int oldData = 0;
        Node pre = searchPre(key);
        if (pre == null) {
            throw new UnsupportedOperationException("没有key的前驱");
        }
        if (pre == this.head && pre.data == key) {
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }
        oldData = pre.next.data;
        Node delNode = pre.next;
        pre.next = delNode.next;
        return oldData;
    }

    private Node searchPre(int key) {
        //1、是不是第一个节点 if(head.data == key)
        Node pre = this.head;
        if(pre!=null&&pre.data == key) {
            return this.head;
        }
        //2、if(cur.next.data == key)
        while(pre!=null&&pre.next != null){
            if(pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(int key) {
        Node pre = this.head;
        Node cur = this.head.next;
        while(cur != null) {
            if(cur.data == key) {
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        if(this.head.data == key) {
            this.head = this.head.next;
        }
    }

    @Override
    public int getLength() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while (this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            this.head = cur;
        }
    }

    //校验回文   把中间之后的节点反指
    public boolean chkPalindrome() {
        if (this.head == null) {
            return false;
        } else if (this.head.next == null) {
            return true;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node p = slow.next;
        Node p1 = p.next;
        while (p != null) {
            p.next = slow;
            slow = p;
            p = p1;
            if (p1 != null) {
                p1 = p1.next;
            }
        }
        while (slow != this.head) {
            if (slow.data != this.head.data) {
                return false;
            }
            if (this.head.next == slow) {
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }

    //单链表的逆置(头插法进行逆置)
    public Node reverseList() {
        Node reverseHead = null;
        Node prev = null;
        Node cur = this.head;
        while (cur != null) {
            Node curNext = cur.next;
            if (curNext == null) {
                reverseHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return reverseHead;
    }

    //删除所有的重复元素
    public Node deleteDuplication() {
        Node newHead = new Node(-1);
        Node tmpHead = newHead;
        Node cur = this.head;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
                newHead.next = cur;
            } else {
                newHead.next = cur;
                newHead = cur;
                cur = cur.next;
            }
        }
        return tmpHead.next;
    }

    //将data小于x的节点放在前面.data大于x的节点放在后面
    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node pHead = this.head;
        while (pHead != null) {
            Node pHeadNext = pHead.next;
            pHead.next = null;
            if (pHead.data < x) {
                if (beforeStart == null) {
                    beforeStart = pHead;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = pHead;
                    beforeEnd = beforeEnd.next;
                }
            } else {
                if (afterStart == null) {
                    afterStart = pHead;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = pHead;
                    afterEnd = afterEnd.next;
                }
            }
            pHead = pHeadNext;
        }
        //第一段没有数据的时候,单链表中所有数据都比x大
        if (beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    //创建一个环
    public void createCycle() {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next;
    }

    //是否有环   走两步    走一步
    public boolean hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast != null && slow != null && slow == fast) {
            return true;
        }
        return false;
    }

    //找到环的入口
    public Node detectCyle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //查找倒数第几个元素
    public Node findKthToTail(int k) {
        Node fast = this.head;
        Node slow = this.head;
        if (fast == null || k <= 0 || k > getLength()) {
            return null;
        }
        while (k - 1 > 0) {
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node middleNode() {
        Node cur=this.head;
        int len=getLength()/2;
        for (int i = 0; i < len; i++) {
            cur=cur.next;
        }
        return cur;
    }

    public void show(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
