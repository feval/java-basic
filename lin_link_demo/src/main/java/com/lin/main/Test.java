package com.lin.main;

import com.lin.ISequence;
import com.lin.impl.MySingleListImpl;
import com.lin.impl.SequenceImpl;

/**
 * Description:
 * Author:  llf
 * Created in 2019/5/7 12:40
 */
public class Test {
    public static void main1(String[] args) {
        SequenceImpl sequence = new SequenceImpl();
        for (int i = 0; i < 10; i++) {
            sequence.add(i, i);
        }
        sequence.display();
        sequence.add(10, "bite");
        sequence.display();

        sequence.add(10, "java");
        sequence.display();

        sequence.remove("bite");
        sequence.display();
        sequence.clear();
        sequence.display();
        for (int i = 0; i < 10; i++) {
            sequence.add(i, i);
        }
        sequence.clear();
    }


    public static void main(String[] args) throws InterruptedException {
        MySingleListImpl mySingleList = new MySingleListImpl();
        // mySingleList.addFirst(18);
        mySingleList.addLast(1);
        // mySingleList.addIndex(1, 20);
        mySingleList.addLast(2);
        mySingleList.addLast(13);
        mySingleList.addLast(14);
        mySingleList.addLast(15);
        mySingleList.addLast(16);
        mySingleList.display();
        MySingleListImpl mySingleList1 = new MySingleListImpl();
        mySingleList1.addLast(9);
        mySingleList1.addLast(10);
        mySingleList1.addLast(11);
        mySingleList1.addLast(12);
        mySingleList1.addLast(13);
        mySingleList1.display();

/*        System.out.println("===========================");
        MySingleListImpl.Node cur1 = mergeTwoLists(mySingleList.getHead(), mySingleList1.getHead());
        mySingleList.show(cur1);

        createCut(mySingleList.getHead(), mySingleList1.getHead());
        System.out.println("=========================");
        mySingleList.display();
        mySingleList1.display();
        System.out.println("===============");
        MySingleListImpl.Node cur2= getIntersectionNode(mySingleList.getHead(), mySingleList1.getHead());
        System.out.println(cur2.getData());
        mySingleList.createCycle();
        System.out.println(mySingleList.hasCycle());

        MySingleListImpl.Node cur3=mySingleList.detectCyle();
        System.out.println(cur3.getData());

        mySingleList.display();

        System.out.println("==========================");
        //System.out.println(mySingleList.chkPalindrome());
        mySingleList.reverseList();
        mySingleList.show(mySingleList.reverseList());
        mySingleList.show(mySingleList.deleteDuplication());
        MySingleListImpl.Node cur = mySingleList.partition(97);
        mySingleList.show(cur);*/

/*
        MySingleListImpl.Node cur1 = mySingleList.findKthToTail(6);
        System.out.println(cur1.getData());

        MySingleListImpl.Node cur = mySingleList.middleNode();
        System.out.println(cur.getData());
*/

        System.out.println(mySingleList.contains(178));
        mySingleList.removeAllKey(18);
        mySingleList.display();
        //mySingleList.clear();
        Thread.sleep(1000);
        System.out.println("睡醒了");
        mySingleList.remove(13);
        mySingleList.display();
        mySingleList.remove(15);
        mySingleList.display();
    }


    //参数为对应单链表的头结点   交叉链表的相遇点
    private static MySingleListImpl.Node getIntersectionNode(MySingleListImpl.Node headA, MySingleListImpl.Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int headALength = 0;
        int headBLength = 0;
        //pL永远指向最长的单链表
        MySingleListImpl.Node pL = headA;
        //pL永远指向最短的单链表
        MySingleListImpl.Node pS = headB;
        while (pL != null) {
            headALength++;
            pL = pL.getNext();
        }
        while (pS != null) {
            headBLength++;
            pS = pS.getNext();
        }
        pL = headA;
        pS = headB;
        int myLen = headALength - headBLength;
        if (myLen < 0) {
            pL = headB;
            pS = headA;
            myLen = headBLength - headALength;
        }
        for (int i = 0; i < myLen; i++) {
            pL = pL.getNext();
        }
        while (pL != null && pS != null && pL != pS) {
            pL = pL.getNext();
            pS = pS.getNext();
        }
        if (pL != null && pS != null && pL == pS) {
            return pL;
        }
        return null;
    }

    //创建两个相交的单链表
    private static void createCut(MySingleListImpl.Node headA, MySingleListImpl.Node headB) {
        headA.next = headB.next.next;
    }

    //合并两个有序的单链表
    private static MySingleListImpl.Node mergeTwoLists(MySingleListImpl.Node headA, MySingleListImpl.Node headB) {
        MySingleListImpl mySingleList = new MySingleListImpl();
        MySingleListImpl.Node node = mySingleList.new Node(-1);
        MySingleListImpl.Node tmpNode = node;
        while (headA != null && headB != null) {
            if (headA.getData() > headB.getData()) {
                tmpNode.next = headB;
                headB = headB.next;
                tmpNode = tmpNode.next;
            } else {
                tmpNode.next = headA;
                headA = headA.next;
                tmpNode = tmpNode.next;
            }
        }
        if (headA != null) {
            tmpNode.next = headA;
        }
        if (headB != null) {
            tmpNode.next = headB;
        }
        return node.next;
    }
}
