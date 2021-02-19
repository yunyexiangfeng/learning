package com.leetcode.bitmanipulation;

import org.junit.Test;

/**
 * 剑指 Offer 15. 二进制中1的个数
 *
 * 请实现一个函数，输入一个整数，
 * 输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。
 * 因此，如果输入 9，则该函数输出 2
 *
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class HammingWeight {

    @Test
    public void test(){
        System.out.println(hammingWeight(9));
    }

    /**
     * '&'运算，同1为1，不同为0。为1，则count ++
     * 每一位计算完毕后右移
     *
     * '>>>'用于无符号右移操作(java是无符号数据类型)
     * '>>'用于有符号位移操作
     *
     * 有符号类型：最高位用于存储符号类型
     * 
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            count += n & 1;
            n = n>>>1;
        }
        return count;
    }
}
