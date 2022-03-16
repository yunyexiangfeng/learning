package com.leetcode.linkedlist;

import java.util.function.BiFunction;

/**
 * https://leetcode-cn.com/problems/sum-lists-lcci/
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> function = (x, y) -> {
            if(x.intValue() >= y.intValue()) return x;
            else return y;
        };
//        System.out.println(function.apply(1, 1));

        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(2);
        print(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head = new ListNode(0);
        while (l1.next != null || l2.next != null){
            if (l1.next != null && l2.next != null){
                head.next = new ListNode(l1.next.val + l2.next.val);
                l1 = l1.next;
                l2 = l2.next;
            }else if (l1.next != null && l2.next == null){
                head.next = new ListNode(l1.next.val);
                l1 = l1.next;
            }else if (l1.next == null && l2.next != null){
                head.next = new ListNode(l2.next.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        return head;
    }

    /**
     * 打印链表
     * @param head 表头
     */
    private static void print(ListNode head){
        if (head == null)
            return;
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    /**
     * 链表类
     */
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
