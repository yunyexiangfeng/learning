package com.leetcode.binarytree;

import java.util.*;

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

//        List<List<Integer>> lists = lod.listOfDepth(tn);
//        for (List list : lists){
//            System.out.println(list.toString());
//        }

        ListNode[] listNodes = lod.listOfDepth(tn);
        for (ListNode ln : listNodes){
            print(ln);
            System.out.println();
        }

    }

    /**
     * 二叉树 广度优先遍历
     * @param tree binary tree
     * @return
     */
    public List<List<Integer>> dfs(TreeNode tree) {
        if (tree == null){
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> root = new ArrayList<>();
        queue.offer(tree);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            TreeNode poll = queue.poll();
            if (poll.left != null){
                queue.offer(poll.left);
            }
            if (poll.right != null){
                queue.offer(poll.right);
            }
            list.add(poll.val);
            root.add(list);
        }
        return root;
    }

    private Map<Integer, ListNode> listNodeMap = new HashMap<>();
    public ListNode[] listOfDepth(TreeNode tree){
        if (tree == null){
            return null;
        }
        int depth = 0;
        bfs(tree, depth);
        //将ListNode map转成ListNode数组
        if (listNodeMap.size() > 0){
            ListNode[] lns = new ListNode[listNodeMap.size()];
            for (Map.Entry<Integer, ListNode> entry : listNodeMap.entrySet()){
                lns[entry.getKey()] = entry.getValue();
            }
            return lns;
        }
        return null;
    }

    /**
     * 二叉树 深度优先遍历
     * @param tree binary tree
     * @param depth depth of tree
     */
    private void bfs (TreeNode tree, int depth){
        ListNode ln = listNodeMap.get(depth);
        if (ln == null){
            listNodeMap.put(depth, new ListNode(tree.val));
        }else {
            while (ln.next != null){
                ln = ln.next;
            }
            ln.next = new ListNode(tree.val);
        }
        depth ++;
        if (tree.left != null){
            bfs(tree.left, depth);
        }
        if (tree.right != null){
            bfs(tree.right, depth);
        }
    }


    private static void print(ListNode ls){
        while (ls != null){
            System.out.print(ls.val + ",");
            ls = ls.next;
        }
    }

    static private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
