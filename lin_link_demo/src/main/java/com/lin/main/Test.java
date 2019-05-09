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
        SequenceImpl sequence=new SequenceImpl();
        for (int i = 0; i < 10; i++) {
            sequence.add(i,i);
        }
        sequence.display();
        sequence.add(10,"bite");
        sequence.display();

        sequence.add(10,"java");
        sequence.display();

        sequence.remove("bite");
        sequence.display();
        sequence.clear();
        sequence.display();
        for (int i = 0; i < 10; i++) {
            sequence.add(i,i);
        }
        sequence.clear();
    }

    public static void main(String[] args) {
        MySingleListImpl mySingleList=new MySingleListImpl();
        mySingleList.addFirst();
    }
}
