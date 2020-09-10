package com.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * 剑指 Offer 47. 礼物的最大价值
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，
 * 每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，
 * 并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 条件：
 * 0 < grid.length <= 200
 * 0 < grid[0].length <= 200
 *
 */
public class MaxValue {
    @Test
    public void test(){

        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
//        System.out.println(maxValue1(grid));
        System.out.println(maxValue2(grid));
    }

    /**
     * 此题目类似于(0,1)背包问题
     * 动态规划
     *
     * V(i, j - i), V(i - 1, j)的最大值决定该往哪个方向移动
     *
     * 转移函数：
     * 1.当i == 0, j != 0，即矩阵第一行，有V(x, j) = grid(0, j - 1) + grid(i, j)
     * 2.当i != 0, j == 0，即矩阵第一列，有V(x, j) = grid(i - 1, 0) + grid(i, j)
     * 3.当i != 0, j != 0，V(x, j) = max(grid(i, j - 1), grid(i - 1, j)) + grid(i, j)
     *
     * 时间复杂度：O（m * n）
     * 空间复杂度：O（1）
     * @param grid
     * @return
     */
    public int maxValue1(int[][] grid) {
        //此方法直接使用grid作为转移函数V，可降低空间复杂度

        int n = grid.length;
        int m = grid[0].length;
        //初始化第一行
        for (int i = 1; i < m; i ++){
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        //初始化第一列
        for (int i = 1; i < n; i ++){
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i ++){
            for (int j = 1; j < m; j ++){
                grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[n - 1][m - 1];
    }

    /**
     * 动态规划，使用额外空间
     * 时间复杂度：O（m * n）
     * 空间复杂度：O（m * n）
     * @param grid
     * @return
     */
    public int maxValue2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i ++){
            for (int j = 1; j <= m; j ++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
//                System.out.print(dp[i][j] + " ");
            }
//            System.out.println();
        }

        for (int i = 0; i <= n; i ++){
            for (int j = 0; j <= m; j ++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][m];
    }
}
