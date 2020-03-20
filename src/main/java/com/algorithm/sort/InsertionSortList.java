package com.algorithm.sort;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.algorithm.sort
 * @ClassName: InsertionSortList
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2019/11/22 20:28
 */
/*
* 对链表进行插入排序
*
* 1.插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
* 2.每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
* 3.重复直到所有输入数据插入完为止。
*
* 来源：力扣（LeetCode）
* 链接：https://leetcode-cn.com/problems/insertion-sort-list
* 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* */
public class InsertionSortList {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode solution(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode tmpNode = head;
        while (head.next != null){
            if (head.val > head.next.val){
                tmpNode = head.next;
                head.next = head.next.next;
                tmpNode.next = head;
            }
        }
        return tmpNode;

    }
}
