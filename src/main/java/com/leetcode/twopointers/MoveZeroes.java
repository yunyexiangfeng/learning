package com.leetcode.twopointers;

import org.junit.Test;

public class MoveZeroes {
    @Test
    public void test(){
//        int[] nums = {0,1,0,3,12};
        int[] nums = {0,0,1};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    /**
     * 暴力法
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == 0){
                count ++;
                for (int j = i; j < nums.length - 1; j ++){
                    nums[j] = nums[j + 1];
                }
            }
        }
        for (int i = nums.length - 1; i >= nums.length - count; i --){
            nums[i] = 0;
        }
    }
}
