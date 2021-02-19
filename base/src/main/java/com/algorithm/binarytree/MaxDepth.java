package com.algorithm.binarytree;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.algorithm.binarytree
 * @ClassName: MaxDepth
 * @Author: Administrator
 * @CreateDate: 2019/11/23 15:21
 * @Description: 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
 */

public class MaxDepth {
    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 设节点数N
     * 时间复杂度：O(N),即为节点数
     * 空间复杂度：O(logN),递归深度，即树高度h
     *          N = (h + 2^h)/2
     *          推出：h = logN
     * @param root
     * @return
     */
    public int solution(TreeNode root) {

        return recursion(root);
    }

    public int recursion(TreeNode node){
        int deep = 1;
        if (node == null){
            return 0;
        }
        deep += Math.max(recursion(node.left), recursion(node.right));
        return deep;
    }
}
