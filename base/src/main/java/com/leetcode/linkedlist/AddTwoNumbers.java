package com.leetcode.linkedlist;


/**
 * https://leetcode-cn.com/problems/sum-lists-lcci/
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(1);
//        l1.next.next = new ListNode(6);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(2);
        Util.print(addTwoNumbers(l1, l2));
    }

    /**
     * 链表求和
     * 反向链表，个位排在链表首部
     * tips: 创建一个新链表
     * 如果是正向链表，可构建两个栈
     * @param l1 链表1
     * @param l2 链表2
     * @return 链表求和结果
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        //临时节点
        ListNode node = new ListNode(0);
        //头节点
        ListNode head = node;
        int count = 0;
        while (l1 != null || l2 != null || count != 0){
            int sum = 0;
            if (l1 != null){
                sum = l1.val + sum;
                l1 = l1.next;
            }
            if (l2 != null){
                sum = l2.val + sum;
                l2 = l2.next;
            }
            //个位
            node.next = new ListNode((sum + count) % 10);
            //十位
            count = (sum + count) / 10;
            //移动指针
            node = node.next;
        }
        return head.next;
    }

}
