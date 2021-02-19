package com.algorithm.stack;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * Created by OY on 2020/5/3.
 */
public class MaxSlidingWindow {
    @Test
    public void test() throws Exception {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 8;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    /**
     * 暴力法
     * 每次遍历窗口（遍历次数k），找到最大值
     * 窗口数量N：nums.length - k + 1
     * 时间复杂度：O(Nk)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 0){
            return new int[0];
        }
        if (k <= 0 || k > nums.length){
            return null;
        }
        int[] maxNums = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i ++){
            int m = i + k - 1;
            int max = nums[i];
            System.out.println(nums[m]);
            for (int  j = i; j <= m; j ++){
                max = Math.max(nums[j], max);
            }
            maxNums[i] = max;
        }
        return maxNums;
    }

    /**
     * dequeue实现
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowDequeue(int[] nums, int k) {
        if (nums.length <= 0){
            return new int[0];
        }
        if (k <= 0 || k > nums.length){
            return null;
        }
        int[] maxNums = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i ++){
            int m = i + k - 1;
            int max = nums[i];
            System.out.println(nums[m]);
            for (int  j = i; j <= m; j ++){
                max = Math.max(nums[j], max);
            }
            maxNums[i] = max;
        }
        return maxNums;
    }

}
