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


    public static void main(String[] args) {
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

        System.out.println("===========================");
        MySingleListImpl.Node cur = cur = mergeTwoLists(mySingleList.getHead(), mySingleList1.getHead());
        mySingleList.show(cur);
    }

    private static MySingleListImpl.Node mergeTwoLists(MySingleListImpl.Node headA, MySingleListImpl.Node headB) {
        MySingleListImpl mySingleList = new MySingleListImpl();
        MySingleListImpl.Node node = mySingleList.new Node(-1);
        MySingleListImpl.Node tmpNode = node;
        while (headA != null && headB != null) {
            if (headA.getData()>headB.getData()) {
                tmpNode.next=headB;
                headB=headB.next;
                tmpNode=tmpNode.next;
            }else {
                tmpNode.next=headA;
                headA=headA.next;
                tmpNode=tmpNode.next;
            }
        }
        if (headA!=null) {
            tmpNode.next=headA;
        }
        if (headB!=null) {
            tmpNode.next=headB;
        }
        return node.next;
    }
}
