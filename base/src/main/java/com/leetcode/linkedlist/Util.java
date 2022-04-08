package com.leetcode.linkedlist;

/**
 * 工具类
 */
public class Util {

    /**
     * 打印链表
     * @param head 表头
     */
    public static void print(ListNode head){
        if (head == null)
            return;
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}
