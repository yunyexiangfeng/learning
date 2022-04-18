package com.algorithm.binarytree;


/**
 * 广度优先遍历二叉树
 */
public class DfsTree {
    public static void main(String[] args) {

        TreeNode tn = new TreeNode(1);
        tn.left = new TreeNode(2);
        tn.right = new TreeNode(3);

        tn.left.left = new TreeNode(4);
        tn.left.right = new TreeNode(5);
        tn.right.right = new TreeNode(7);

        tn.left.left.left = new TreeNode(8);

        dfs(tn);
    }

    /**
     * Depth first search
     * @param tree tree
     */
    private static void dfs(TreeNode tree){
        if (tree == null){
            return;
        }
        System.out.println(tree.val);
        if (tree.left != null){
            dfs(tree.left);
        }
        if (tree.right != null){
            dfs(tree.right);
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
