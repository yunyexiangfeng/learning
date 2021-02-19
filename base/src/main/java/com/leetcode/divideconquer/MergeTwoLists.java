package com.leetcode.divideconquer;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 题目描述：
 * 输入两个递增排序的链表，
 * 合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 */
public class MergeTwoLists {

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;

//        ListNode listNode = this.mergeTwoLists(l1, l2);
        ListNode listNode = this.mergeTwoListsByMerge(l1, l2);
        printNode(listNode);
    }

    /**
     * 遍历实现归并排序的后半部分，即对拆分后的数组实现合并
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode tempNode = newNode;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                newNode.next = l1;
                l1 = l1.next;
            }else {
                newNode.next = l2;
                l2 = l2.next;
            }
            newNode = newNode.next;
        }
        while (l1 != null){
            newNode.next = l1;
            newNode = newNode.next;
            l1 = l1.next;
        }
        while (l2 != null){
            newNode.next = l2;
            newNode = newNode.next;
            l2 = l2.next;
        }
        return tempNode.next;
    }

    /**
     * 递归实现归并排序的后半部分
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsByMerge(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val <= l2.val){
            l1.next = mergeTwoListsByMerge(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoListsByMerge(l1, l2.next);
            return l2;
        }
    }
    public void printNode(ListNode node){
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
