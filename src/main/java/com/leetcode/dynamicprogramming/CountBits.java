package com.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
 * 计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 进阶
 *  1.给出时间复杂度为O(n*sizeof(integer))的解答非常容易。
 *  但你可以在线性时间O(n)内用一趟扫描做到吗？
 *  2.要求算法的空间复杂度为O(n)。
 *  3.你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置
 *  函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */
public class CountBits {

    @Test
    public void test(){

        int[] ans = countBits(5);
        for (int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }

    /**
     * 暴力法
     * 时间复杂度：O（n * ）
     * 空间复杂度：O（n）
     *
     * 对0 ≤ i ≤ num的数字i进行除2取余，余数为1，则自加
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        //数据范围为0 ≤ i ≤ num，所以数组长度应该为num + 1
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i ++){
            int count = 0;
            int m = i;
            while (m > 0) {
                if (m % 2 == 1){
                    count ++;
                }
                m = m/2;
            }
            ans[i] = count;
        }
        return ans;
    }

    /**
     * 优化：动态规划
     *
     *
     * @param num
     * @return
     */
    public int[] countBitsOptimization(int num) {
        //数据范围为0 ≤ i ≤ num，所以数组长度应该为num + 1
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i ++){
            int count = 0;
            int m = i;
            while (m > 0) {
                if (m % 2 == 1){
                    count ++;
                }
                m = m/2;
            }
            ans[i] = count;
        }
        return ans;
    }

}
