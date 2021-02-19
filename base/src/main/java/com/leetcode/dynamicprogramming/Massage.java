package com.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 * 面试题 17.16. 按摩师
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 *
 * 1.dynamic programming
 * 2.迭代法
 */
public class Massage {
    @Test
    public void test(){
//        int[] array = {2,1,4,5,3,1,1,3};
        int[] array = {2,1,1,2};//提交报错
        System.out.println(message(array));
        System.out.println(messageOptimization(array));
    }

    /**
     * 动态规划
     * 根据题目可知：nums为正整数数组
     * 对于第i次预约：
     * 1.接受预约：时长T[i] = T[i - 2] + t[i]
     * 2.不接受预约：时长T[i] = T[i - 1]
     * 综合，取最大值 => T[i] = max((T[i - 2] + t[i]), T[i - 1])
     * @param nums
     * @return
     */
    public int message(int[] nums){
        if(nums.length == 0){
            return 0 ;
        }
        if (nums.length < 2){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] T = new int[nums.length];
        //当i = 0
        T[0] = nums[0];
        T[1] = Math.max(T[0], nums[1]);
        for (int i = 2; i < nums.length; i ++){
            T[i] = Math.max(T[i - 2]  + nums[i], T[i - 1]);
        }
        //取出最大值
        int max = 0;
        for (int i = 0; i < T.length; i ++){
//            System.out.println(T[i]);
            max = Math.max(T[i], max);
        }
        return max;
    }

    /**
     * 动态规划优化
     * 与message方法解题思路相同
     * 对于T[i] = max((T[i - 2] + t[i]), T[i - 1])函数，只需要记录T[i - 2]和T[i - 1]值即可
     * @param nums
     * @return
     */
    public int messageOptimization(int[] nums){
        int t0 = 0;//T[i - 2]
        int t1 = 0;//T[i - 1]

        int temp;
        for (int i = 0; i < nums.length; i ++){
            temp = t1;
            t1 = Math.max(t0 + nums[i], t1);
            t0 = temp;
        }
        return t1;
    }
}
