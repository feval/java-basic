package com.lin.test;

import com.lin.impl.TestHeap;
import com.lin.test.TestBinaryTree;

/**
 * Description:
 * Author:  llf
 * Created in 2019/7/26 16:50
 */
public class Test {
    public static void main1(String[] args) {
        TestHeap testHeap=new TestHeap();
        int[] array = {1,2,3,4,5,6,7,8,9};
        testHeap.initHeap(array);
        testHeap.show();
        testHeap.pushHeap(10);
        testHeap.show();
        testHeap.popHeap();
        testHeap.show();
        testHeap.HeapSort();
        testHeap.show();
    }

    public static void main(String[] args) {
        TestBinaryTree testBinaryTree=new TestBinaryTree();
        //TestBinaryTree.TreeNode treeNode= TestBinaryTree.TreeNode();
    }
}
