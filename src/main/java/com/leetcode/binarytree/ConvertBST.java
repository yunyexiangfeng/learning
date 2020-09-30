package com.leetcode.binarytree;

import org.junit.Test;

/**
 * 538. 把二叉搜索树转换为累加树
 * 简单
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 */
public class ConvertBST {

    @Test
    public void test(){
        //构建测试用例
        //用例1: [5,2,13]，预期结果[18,20,13]
        /*TreeNode root = new TreeNode(5);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(13);

        root.left = left;
        root.right = right;*/
        //用例2: [2,0,3,-4,1]，预期结果[5,6,3,2,6]

        TreeNode root = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left = new TreeNode(0);
        root.left = left;
        root.right = right;

        left.right = new TreeNode(1);
        left.left = new TreeNode(-4);

        //convert bst
        TreeNode convert = convertBST(root);
        //print node
        printNode(convert);

    }
    private TreeNode convertBST(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode right = convertBST(root.right);
        if (right != null){
            root.val += right.val;
        }
        TreeNode left = convertBST(root.left);
        if (left != null){
            left.val += root.val;
            root.left = left;
        }
        return root;
    }

    private void printNode(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        printNode(root.left);
        printNode(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
