package com.leetcode.dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 * Middle
 *
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 */
public class MinimumTotal {

    @Test
    public void test(){

        //构造测试用例
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> one  = new ArrayList<>();
        one.add(2);
        triangle.add(one);
        List<Integer> two  = new ArrayList<>();
        two.add(3);
        two.add(4);
        triangle.add(two);
        List<Integer> thr  = new ArrayList<>();
        thr.add(6);
        thr.add(5);
        thr.add(7);
        triangle.add(thr);
        List<Integer> four  = new ArrayList<>();
        four.add(4);
        four.add(1);
        four.add(8);
        four.add(3);
        triangle.add(four);
        System.out.println("triangle : " + triangle.toString());
        System.out.println(minimumTotal(triangle));
    }

    /**
     * 动态规划
     *
     * 状态函数：
     * dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        //当triangle只有一个顶点时
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(triangle.get(0));
        int m = triangle.size();
        for (int i = 1; i < m; i ++){
            int n = triangle.get(i).size();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j ++){
                if (j == 0){
                    list.add(dp.get(i - 1).get(j) + triangle.get(i).get(j));
                }else if (j == (n - 1)){
                    list.add(dp.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                }else {
                    list.add(Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)) + triangle.get(i).get(j));
                }
            }
            dp.add(list);
        }
//        System.out.println("dp : " + dp.toString());
        //取出最小值。dp最后一行的最小值为本题目解
        List<Integer> integers = dp.get(dp.size() - 1);
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < integers.size(); i ++){
            minValue = Math.min(minValue, integers.get(i));
        }
        return minValue;
    }
}
