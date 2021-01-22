package com.algorithm;

import java.util.*;

/**
 * @version 1.0
 * @ProjectName: fremer
 * @Package: com.ham.han.fremer.algorithm
 * @ClassName: algorithm
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2019/8/10 20:46
 */
public class algorithm {
    public static void main(String[] args) {

//        lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABC\n");
//        lengthOfLongestSubstring("dfsdfsdfsdfdfhfbbv");

        /*int[] num1 = new int[]{3};
        int[] num2= new int[]{-2,-1};
        System.out.println(findMedianSortedArrays(num1,num2));*/

//        reverse(123);

        /*String strs[] = {"flower","flow","flight"};
        longestCommonPrefix(strs);*/

        /*int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        maxArea(height);*/
        Map<String, String> map = new HashMap<>();
        map.put("1","tenant1");
        map.put("2","tenant1");
        map.put("3","tenant1");
        System.out.println(map.remove("*","tenant1"));
        System.out.println(map.toString());
    }

    //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            head = null;
            return head;
        }
        int size = 1;
        ListNode headBackup = new ListNode(head.val);
        ListNode headNextBackup = head.next;
        while (head.next != null){
            size ++;
            ListNode next = head.next;
            head = next;
        }
        head = headBackup;
        head.next = headNextBackup;
        if (n==size){
            head = head.next;
        }

        int point = 0;
        while (head.next != null){
            point ++;
            if ((n == size - point)){
                head.next = head.next.next;
                break;
            }
            ListNode next = head.next;
            head = next;
        }
        return head;
    }

    //盛最多水的容器
    public static int maxArea(int[] height) {
        int volume = 0;
        //暴力法
        /*for (int i = 0; i < height.length; i ++){
            for (int j = i + 1; j < height.length; j ++){
                int len = j - i;
                volume = Math.max(volume, len * (Math.min(height[j], height[i])));
            }
        }*/
//        return volume;

        //排除法，排除的面积不可能大于当前面积
        //指针移动的同时，横轴长度减小。只有每次指针n移动后的下一个值m大于n，得到的面积才有可能大于初始值
        int l = 0;
        int r = height.length - 1;
        while (l < r){
            volume = Math.max(volume, (r - l) * (Math.min(height[l], height[r])));
            if (height[l] < height[r]){
                l ++;
            }else {
                r --;
            }
        }

        return volume;
    }
    //整数反转
    public static int reverse(int x) {
        //range of Integer
//        int low = - Math.pow(2, 32);
//        int high = - Math.pow(2, 32);

        String xs = String.valueOf(x);
        char[] characters = new char[xs.length()];
        int index = 0;
        for (int i = xs.length() - 1; i >= 0; i --){
            characters[index] = xs.charAt(i);
            index ++;
        }
        String xxs = new String(characters);
        int xx = Integer.valueOf(xxs);
        System.out.println(xx);
        Integer.reverse(x);
        return xx;

    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        int minLen = strs[0].length();
        for (String s : strs){
            if (minLen > s.length()){
                minLen = s.length();
            }
        }
        char[] chars = new char[minLen];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < minLen; i ++){
            chars[i] = strs[0].charAt(i);
            int count = 0;
            for (String s : strs){
                if (chars[i] == s.charAt(i)){
                    count ++;
                }
            }
            if (count != strs.length){
                break;
            }
            sb.append(strs[0].charAt(i));
        }
        if (chars.length == 0){
            return "";
        } else {
            System.out.println(sb.toString());
            return sb.toString();
        }
    }
    public static int lengthOfLongestSubstring(String s) {

        //最初始方法
        /*if (s == null || "".equals(s)){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        Set set = new HashSet();
        for(int i = 0 ; i< s.length();i++){
            for(int j=i+1;j<s.length();j++){
                set.add(s.charAt(i) + "");
                String ss = s.substring(i,j + 1);
                set.add(ss);
            }
        }
        int count = 0;
        Iterator iterator = set.iterator();
        Set set2 = new HashSet();
        while (iterator.hasNext()){
            String next = (String) iterator.next();
            char[] cs = next.toCharArray();
            boolean flag = false;
            for (int i = 0 ; i < cs.length; i ++){
                for (int j = i + 1; j < cs.length; j ++){
                    if (cs[i] == cs[j]){
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag){
                set2.add(next);
            }
        }
        System.out.println("-----------------------");
        Iterator iterator1 = set2.iterator();
        while (iterator1.hasNext()){
            String next = (String) iterator1.next();
            System.out.println(next);
            if (next.length() > count){
                count = next.length();
            }
        }
        System.out.println(count);
        return count;*/

        //推荐暴力法
        /*int ano = 0;
        for(int i = 0 ; i< s.length();i++){
            for(int j=i+1;j<s.length();j++){

                if (allUnique(s, i, j)){
                    ano = Math.max(ano, j - i);
                }
            }
        }
        System.out.println(ano);
        return ano;*/

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            //dfsdfsdfsdfdfhfbbv
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                Iterator<Character> iterator = set.iterator();
                while (iterator.hasNext()){
                    System.out.print(iterator.next());
                }
                System.out.println();
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
                Iterator<Character> iterator = set.iterator();
                while (iterator.hasNext()){
                    System.out.print(iterator.next());
                }
                System.out.println();
            }
        }
        return ans;
    }
    public static boolean allUnique(String s, int start, int end){
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end ; i++){
            Character c = s.charAt(i);
            if (set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        LinkedList list = new LinkedList();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int n = Math.max(len1, len2);
        int m = Math.min(len1, len2);
        for (int i = 0; i < m; i ++){
            list.add(Math.min(nums1[i],nums2[i]));
            list.add(Math.max(nums1[i],nums2[i]));
        }

        if (len1 >= len2){
            for (int i = m; i < n; i ++){
                list.add(nums1[i]);
            }
        }else {
            for (int i = m; i < n; i ++){
                list.add(nums2[i]);
            }
        }

        int size = list.size();
        for (int i = 0 ; i < list.size(); i ++){
            System.out.println(list.get(i));
        }
        System.out.println("---------------------");
        for (int i = 0; i < list.size(); i ++){
            for (int j = i + 1; j < list.size(); j ++){
                if ((int)list.get(i) > (int)list.get(j)){
                    int tmp = (int) list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, tmp);
                }
            }
        }
        for (int i = 0 ; i < list.size(); i ++){
            System.out.println(list.get(i));
        }
        System.out.println("---------------------");
        System.out.println("size : " + size);
        int mid = 0;
        if (size == 0){
            return mid;
        }else {
            if (size % 2 == 0){
                return ((int)list.get(size / 2 - 1) + (int)list.get(size / 2))/2.0;
            }else {
                System.out.println(list.get(size / 2));
                return (int)list.get(size / 2);
            }
        }
    }

}
