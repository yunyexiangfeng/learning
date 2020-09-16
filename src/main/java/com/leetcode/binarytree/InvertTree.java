package com.leetcode.binarytree;

import org.junit.Test;

/**
 *
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class InvertTree {


    @Test
    public void test(){
        //构造测试用例[4,2,7,1,3,6,9]
        //输出结果应该为[4,7,2,9,6,3,1]
        //前序遍历结果[4,7,9,6,2,3,1]

        //root
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);


        TreeNode node = invertTree(root);
        printBinaryTree(node);
    }

    /**
     * 递归
     * 空间复杂度：O(N).二叉树的空间复杂度为递归深度，即树高度。
     * 二叉树每层节点个数n：
     * n = 2^(h - 1)
     * h：树高度，[1 - ∞)
     *
     * 二叉树总节点个数N：
     * N = 2^h - 1
     * =>时间复杂度 O(h) = log2N - 1
     * 在最坏情况下，二叉树退化成链表，时间复杂度退化到O(N)
     *
     * @param root
     * @return
     */
    private TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        this.swap(root);
        return root;
    }

    /**
     * 交换
     * @param root
     */
    private void swap(TreeNode root){
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }

    /**
     * 官方解答，去掉swap操作
     * @param root
     * @return
     */
    private TreeNode invertTreeG(TreeNode root) {
        if (root == null){
            return root;
        }
        root.left = invertTreeG(root.left);
        root.right = invertTreeG(root.right);
        return root;
    }

    /**
     * 使用前序遍历输出结果
     * @param root
     */
    private void printBinaryTree(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
