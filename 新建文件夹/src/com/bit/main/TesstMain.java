package com.bit.main;

import com.bit.dao.MySingListImpl;
import com.bit.dao.Sequencelmpl;

/**
 *
 */
public class TesstMain {
    public static void main(String[] args) {
        MySingListImpl mySingList=new MySingListImpl();
        mySingList.addFirst(18);
        mySingList.addFirst(78);
        mySingList.addFirst(99);
        mySingList.display();//99 78 18
        mySingList.addindex(1,88);
        mySingList.addLast(100);
        mySingList.display();//99 88 78 18 100
        System.out.println(mySingList.contains(78));
    }
    public static void main1(String[] args) {
    Sequencelmpl sequence = new Sequencelmpl();
        for(int i = 0; i < 10; i++) {
        sequence.add(i,i);
    }
        sequence.display();
        sequence.add(10,"bit");
        sequence.display();

        sequence.add(11,"java");
        sequence.display();

        sequence.remove("bit");
        sequence.display();
        System.out.println("================");
        sequence.clear();
        sequence.display();
}
}
