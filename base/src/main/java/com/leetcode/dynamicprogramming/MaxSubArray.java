package com.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组里有正数也有负数。
 * 数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 */
public class MaxSubArray {
    @Test
    public void test(){
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));
        System.out.println(maxSubArrayOptimize(array));
    }

    /**
     * 动态规划
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * dp[i]与dp[i - 1]相关
     * @param array
     * @return
     */
    public int maxSubArray(int[] array){
        int sum = 0;
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i ++){
            if (dp[i - 1] > 0){
                dp[i] = dp[i - 1] + array[i];
            }else {
                dp[i] = array[i];
            }
        }
        for (int i = 0; i < dp.length; i ++){
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }
    /**
     * 动态规划
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * dp[i]与dp[i - 1]相关
     * @param array
     * @return
     */
    public int maxSubArrayOptimize(int[] array){
        //使用sum记录最大值即可，无需新建数组
        int sum = array[0];
        int dp = array[0];
        for (int i = 1; i < array.length; i ++){
            if (dp > 0){
                dp = dp + array[i];
            }else {
                dp = array[i];
            }
            sum = Math.max(sum, dp);
        }
        return sum;
    }
}
