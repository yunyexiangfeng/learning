package com.leetcode.binarytree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class InorderTraversal {

    @Test
    public void test(){

        //构造测试用例 [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root).toString());
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null){
            return values;
        }
        traversal(root, values);
        return values;
    }

    /**
     * recursion traversal
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)，该空间复杂度为递归栈深度
     * @param root
     * @param values
     */
    public void traversal(TreeNode root, List<Integer> values){

        //添加左子节点
        if (root.left != null){
            traversal(root.left, values);
        }
        //添加root节点
        values.add(root.val);
        //添加右子节点
        if (root.right != null){
            traversal(root.right, values);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
