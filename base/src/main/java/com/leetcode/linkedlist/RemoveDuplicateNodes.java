package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class RemoveDuplicateNodes {


    public static void main(String[] args) {
        //构建链表
        ListNode ln = new ListNode(1);
        /*ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(3);
        ln.next.next.next.next = new ListNode(2);
        ln.next.next.next.next.next = new ListNode(1);*/
        ln.next = new ListNode(1);
        ln.next.next = new ListNode(1);
        ln.next.next.next = new ListNode(1);
        ln.next.next.next.next = new ListNode(2);
        ListNode listNode = removeDuplicateNodes(ln);
        print(listNode);
    }

    /**
     * 删除重复节点
     * 使用临时辅助空间(hash map)
     * 官方的另外一种方式为双循环
     * @param head 表头
     * @return 已删除重复节点的链表
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null)
            return null;
        ListNode tHead = head;
        Map<Integer, String> map = new HashMap<>();
        map.put(head.val, null);
        while (head.next != null){
            if (map.containsKey(head.next.val)){
                head.next = head.next.next;
            }else {
                map.put(head.next.val, null);
                head = head.next;
            }
        }
        return tHead;
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
