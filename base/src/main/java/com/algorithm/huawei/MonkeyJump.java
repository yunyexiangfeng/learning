package com.algorithm.huawei;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 此问题可以扩展为k或m级台阶
 * 则递归方式为：
 * F(n) = F(n - k) + F(n - m)
 */
public class MonkeyJump {
    public static void main(String[] args) {
        System.out.println(monkeyJump(5));
        System.out.println(monkeyJumpDynamic(5));
    }

    /**
     * 递归
     * 时间复杂度O(2^n),即二叉树遍历
     * 该方式运行超时
     * @param n
     * @return
     */
    public static int monkeyJump(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return monkeyJump(n - 1) + monkeyJump(n - 2);
    }

    /**
     * 动态规划
     * 时间复杂度O(n)
     * @param n
     * @return
     */
    public static int monkeyJumpDynamic(int n){
        if (n == 1){
            return n;
        }
        //给定一个长度为n + 1的数组
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i ++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
