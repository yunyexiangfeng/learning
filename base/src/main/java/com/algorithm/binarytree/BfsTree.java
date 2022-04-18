package com.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 深度优先遍历二叉树
 */
public class BfsTree {
    public static void main(String[] args) {

        //构造二叉树
        TreeNode tn = new TreeNode(1);
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(3);

        tn.left.left = new TreeNode(4);
        tn.left.right = new TreeNode(5);
        tn.right.right = new TreeNode(7);

        tn.left.left.left = new TreeNode(8);

        bfs(tn);
    }

    /**
     * Breath first search
     * @param tree tree
     */
    private static void bfs(TreeNode tree){
        if (tree == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队
        queue.offer(tree);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if (poll != null){
                System.out.println(poll.val);
            }
            //左子树入队
            if (poll.left != null){
                queue.offer(poll.left);
            }
            //右子树入队
            if (poll.right != null){
                queue.offer(poll.right);
            }
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
}
