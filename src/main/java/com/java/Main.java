package com.java;

import com.java.compareTo.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.java
 * @ClassName: Main
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2019/12/7 13:03
 */
public class Main {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        int ans = 0;
        while (head != null){
            ans = ans << 1;
            ans += head.val;
            head = head.next;
        }
        System.out.println(ans);

    }

    public static Integer getInt(){
        return null;
    }

    public static void personCompare(List<Person> persons){

    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
