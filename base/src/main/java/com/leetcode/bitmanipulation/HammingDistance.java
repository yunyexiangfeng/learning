package com.leetcode.bitmanipulation;

import org.junit.Test;

/**
 * 461. 汉明距离
 * 汉明距离广泛应用于多个领域。在编码理论中用于错误检测，在信息论中量化字符串之间的差异。
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 */
public class HammingDistance {

    @Test
    public void test(){
//        int x = 1, y = 4;
        int x = 9, y = 12;
        System.out.println(hammingDistance(x, y));
    }

    /**
     * 1.利用异或特性（二进制相同为0，不同为1）计算出汉明距离的十进制数
     * 2.利用除2取余法获取二进制位，当余数为1时进行统计
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y){
        int distance = 0;
        //异或操作
        int xor = x ^ y;
        //除2取余法获取二进制位
        while (xor != 0){
            if (xor % 2 == 1){
                distance ++;
            }
            xor = xor/2;
        }
        return distance;
    }
}
