package com.leetcode.twopointers;

import org.junit.Test;

public class MoveZeroes {
    @Test
    public void test(){
        int[] nums = {0,1,0,3,12};
//        int[] nums = {0,0,1};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    /**
     * two-pointer
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        //j指针统计非0个数
        int j = 0;
        for (int i = 0; i < nums.length; i ++){
            //遇到0的时候，i指针继续走，j指针停留在0的位置
            if (nums[i] != 0){
//                nums[j] = nums[i];
                //优化：减少赋值操作
                if (i > j){
                    nums[j] = nums[i];
                }
                j ++;
            }
        }
        //0个数为nums.length - j，用0填充j -- nums.length
        /*for (;j < nums.length; j ++){
            nums[j] = 0;
        }*/
        while (j < nums.length){
            nums[j ++] = 0;
        }
    }
}
