package com.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * 746. 使用最小花费爬楼梯
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 */
public class MinCostClimbingStairs {

    @Test
    public void test(){

//        int[] cost = {10, 15, 20};
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int min = minCostClimbingStairs(cost);
        System.out.println(min);
    }
    public int minCostClimbingStairs(int[] cost) {
        int min = Integer.MAX_VALUE;
        int[] minCost = new int[cost.length];
        minCost[0] = cost[0];
        minCost[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i ++){
            minCost[i] = Math.min(minCost[i - 1] + cost[i], minCost[i - 1]  + cost[i - 1]);
            //对于n
        }
        for (int i = 0; i < minCost.length; i ++){
            System.out.println(minCost[i]);
        }
        return min;
    }
}
