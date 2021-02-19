package com.leetcode.bitmanipulation;

import org.junit.Test;

/**
 * 1290. 二进制链表转整数
 * 简单
 *
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 *
 */
public class GetDecimalValue {

    @Test
    public void test(){
        //构造测试用例{1,0,1}
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(getDecimalValue(head));
    }

    /**
     * '<<'运算符：右移一位。计算机对于该运算符会转换为二进制进行操作，相当于十进制 *2 操作
     * 例如：
     * 对于十进制1，1<<后转换为二进制 '10'，再将‘10’转换为十进制，值为2
     *
     * 此题的解题思路：
     * 十进制转二进制 除2取余法 的逆向过程
     * 例如：二进制10010转十进制后是18
     * 计算过程（公式）：1 * 2^4 + 0 * 2^3 + 0 * 2^2 + 1 * 2^1 + 0 * 2^0
     * 即：(((1 * 2 + 0) * 2 + 0) * 2 + 1) * 2 + 0，将此公式拆分后，即得上面的公式。
     * 10010从左往右，1乘了4次2，0乘了3次2，0乘了2次2，1乘了1次2，再加上0
     *
     * @param head
     * @return
     */
    public int getDecimalValue(ListNode head){
        int ans = 0;
        while (head != null){
//            ans = ans * 2;
            ans = ans << 1;
            ans += head.val;
            head = head.next;
        }
        return ans;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
