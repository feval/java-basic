package com.lin.test;

/**
 * Description:
 * Author:  llf
 * Created in 2019/7/26 18:54
 */
public class TestBinaryTree {
    class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    //根据字符串创建二叉树
    public int i = 0;

    TreeNode createTestTree(String s) {
        TreeNode root = null;
        if (s.charAt(i) != '#') {
            root = new TreeNode(s.charAt(i));
            i++;
            root.left = createTestTree(s);
            root.right = createTestTree(s);
        } else {
            i++;
        }
        return root;
    }

    // 结点个数
    int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.left) + getSize(root.right) + 1;
    }

    // 叶子结点个数
    int getLeafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    // 第 k 层结点个数
    int getKLevelSize(TreeNode root, int k) {
        if (root==null) {
            return 0;
        }
        if (k==1) {
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }

    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，如果找到，返回结点，否则返回 null
    TreeNode find(TreeNode root, int value) {

    }

    // 二叉树的高度
    int height(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if (height(root.left)>height(root.right)) {
            return height(root.left)+1;
        }else {
            return height(root.right)+1;
        }
    }

    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，如果找到，返回结点，否则返回 null
    TreeNode find(TreeNode root, int value) {
        if(root==null) {
            return null;
        }
        if (root.val==value) {
            return root;
        }


    }
    // 二叉树的前序遍历
    void binaryTreePrevOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + " ");
        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
    }

    // 二叉树的中序遍历
    void binaryTreeInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        binaryTreeInOrder(root.left);
        System.out.println(root.val + " ");
        binaryTreeInOrder(root.right);
    }

    //二叉树的后序遍历
    void binaryTreePostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
        System.out.println(root.val + " ");
    }
}
