package com.algorithm.sort;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.algorithm.sort
 * @ClassName: Intersection
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2019/11/22 19:30
 */
/*
*两个数组的交集
*
*给定两个数组，编写一个函数来计算它们的交集
*
* */
public class Intersection {
    /**
     * 时间复杂度：O(M * N)
     *  空间复杂度：O(|M-N|)
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] solutionOne(int[] nums1, int[] nums2){
        int[] nums = new int[0];
        if (nums1.length <= 0 || nums2.length <= 0){
            return nums;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i ++){
            for (int j = 0; j < nums2.length; j ++){
                if (nums1[i] == nums2[j]){
                    set.add(nums1[i]);
                    //加上break，60个测试用例会减少5ms执行时间
                    break;
                }
            }
        }
        if (set.size() > 0){
            nums = new int[set.size()];
            int index = 0;
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()){
                nums[index] = iterator.next();
                index ++;
            }
        }
        return nums;

    }
    //官方解法：for (Integer s : set1)
    //              if (set2.contains(s)) output[idx++] = s;
    //时间复杂度：O(M + N)
}
