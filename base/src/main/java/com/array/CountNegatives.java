package com.array;

import org.junit.Test;

/**
 * 统计二维数组中小于0的数量
 * Created by OY on 2020/4/12.
 */
public class CountNegatives {

    @Test
    public void test(){

    }

    /**
     * 暴力法：
     *  时间复杂度O(m*n)
     *  空间复杂度O(1)
     * @param grid
     * @return
     */
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[i].length; j ++){
                if (grid[i][j] < 0){
                    count ++;
                }
            }
        }
        return count;
    }


}
