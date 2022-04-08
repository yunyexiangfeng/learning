package com.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 * 编写一个函数，检查输入的链表是否是回文的。(解题者注：节点值为int类型)
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome2(head));
    }

    /**
     * 判断链表是否为回文
     * 1. 链表转数组
     * 2. 双指针遍历判断对称位置是否相等
     * @param head 链表表头
     * @return 判断结果，true表示是回字文，false表示为非回字文
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null)
            return false;
        //链表转数组
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        //双指针遍历
        for (int i = 0; i < len; i ++){
            if (list.get(i).intValue() != list.get(len - 1).intValue()){
                return false;
            }
            len --;
        }
        return true;
    }

    private static ListNode node = new ListNode(0);
    /**
     * 判断是否为回字文
     * 1. 递归
     * @param head 链表表头
     * @return 判断结果，true表示是回字文，false表示为非回字文
     */
    public static boolean isPalindrome2(ListNode head) {
        node = head;
        return check(head);
    }
    private static boolean check(ListNode currentNode){
        if (currentNode != null){
            if (!check(currentNode.next)){
                return false;
            }
            if (currentNode.val != node.val){
                return false;
            }
            node = node.next;
        }
        return true;
    }

}
