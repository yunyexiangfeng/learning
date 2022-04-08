package com.algorithm.binarytree;

/**
 * https://leetcode-cn.com/problems/list-of-depth-lcci/
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 * 返回一个包含所有深度的链表的数组。
 */
public class ListOfDepth {
    public static void main(String[] args) {
        ListOfDepth lod = new ListOfDepth();
        //构造树
        TreeNode tn = new TreeNode(1);
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(3);

        tn.left.left = new TreeNode(4);
        tn.left.right = new TreeNode(5);
        tn.right.right = new TreeNode(7);

        tn.left.left.left = new TreeNode(8);

        ListNode[] listNodes = lod.listOfDepth(tn);
        for (ListNode ls : listNodes){
            print(ls);
        }

    }

    public ListNode[] listOfDepth(TreeNode tree) {
        return null;
    }

    private static void print(ListNode ls){
        while (ls != null){
            System.out.print(ls.val + ",");
            ls = ls.next;
        }
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
