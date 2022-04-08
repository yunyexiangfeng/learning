package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-lcci/
 *
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        ListNode posNode = new ListNode(2);
        node.next = posNode;
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        node.next.next.next.next = posNode;
//        Util.print(node);
        ListNode ln = detectCycle(node);
        System.out.println(ln.val);

    }

    /**
     * 环路检测
     * HashMap作为额外空间
     * @param head 链表头节点
     * @return 环路的起始节点
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        Map<ListNode, Object> map = new HashMap<>();
        while (head != null){
            if (map.containsKey(head))
                return head;
            map.put(head, null);
            head = head.next;
        }
        return null;
    }

    /**
     * 双速指针：快速指针 + 慢速指针
     * @param head 链表头节点
     * @return 环路的起始节点
     */
    public static ListNode detectCycle2(ListNode head) {
        if (head == null)
            return null;
        Map<ListNode, Object> map = new HashMap<>();
        while (head != null){
            if (map.containsKey(head))
                return head;
            map.put(head, null);
            head = head.next;
        }
        return null;
    }
}
