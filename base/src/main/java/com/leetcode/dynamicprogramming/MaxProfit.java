package com.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * 121. 买卖股票的最佳时机
 *
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 *
 */
public class MaxProfit {
    @Test
    public void test(){
        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitOptimization(prices));
    }

    /**
     * 暴力法
     * 时间复杂度：O（n!）
     * 空间复杂度：O（1）
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < len; i ++){
            for (int j = i; j < len; j ++){
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    public int maxProfitOptimization(int[] prices) {
        int maxProfit = 0;
        if (prices.length > 0){
            int tmp = prices[0];
            for (int i = 0; i < prices.length; i ++){
                if (prices[i] < tmp)
                    tmp = prices[i];
                maxProfit = Math.max(maxProfit, prices[i] - tmp);

            }
        }
        return maxProfit;
    }
}
