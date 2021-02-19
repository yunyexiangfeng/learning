package com.leetcode;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 * 1221. 分割平衡字符串
 * 题目描述：
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 返回可以通过分割得到的平衡字符串的最大数量。
 *
 * 官方解题思路：
 * 1.题目要求通过分割得到的最大数量，即尽可能多的分割。
 * 2.定义一个变量balance，当balance为0时达到平衡
 * 3.从左往右扫描字符串s，遇到L,balance - 1，遇到R，balance + 1
 * 4.当balance为0时即，更新记录cnt ++
 * 5.如果最后cnt==0，说明s只需要保持原样，返回1
 *
 */
public class BalancedStringSplit {

    @Test
    public void test(){
        //测试用例
        String s = "RLRRLLRLRL";
//        String s = "RLLLLRRRLR";
//        String s = "LLLLRRRR";
        System.out.println(balancedStringSplit(s));
    }

    /**
     *分割平衡字符串
     * 1.要么为连续'R'，要么为连续'L'
     * 2.'R'结束后必为'L'
     * 3.'L'结束后比为'R'
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        int count = 0;
        if (s == null || s.length() == 0){
            return count;
        }
        int rc = 0;
        int lc = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i ++){
            //统计连续'R'或者连续'L'的数量
            if (chars[i] == 'R'){
                rc ++;
            }else {
                lc ++;
            }
            //每一轮 平衡字符串 子串统计完毕后
            //置0，并进行下一轮统计
            if (rc > 0 && rc == lc){
                count ++;
                lc = 0;
                rc = 0;
            }
        }
        return count;
    }

    /**
     * 官方解法
     * 少一个int值定义
     * @param s
     * @return
     */
    /*int balancedStringSplit(String s) {
        int cnt = 0;
        int balance = 0;
        for(int i = 0; i < s.length(); i++){
            if(s[i] == 'L') balance --;
            if(s[i] == 'R') balance ++;
            if(balance == 0) cnt ++;
        }
        return cnt;
    }*/
}
