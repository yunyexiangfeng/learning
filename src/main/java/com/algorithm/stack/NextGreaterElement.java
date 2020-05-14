package com.algorithm.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by OY on 2020/4/25.
 */
public class NextGreaterElement {

    @Test
    public void test(){

        //[4,1,2]
        int[] nums1 = {4,1,2};
        //[1,3,4,2]
        int[] nums2 = {1,3,4,2};
        int[] ints = nextGreaterElementWithStack(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 暴力法
     * 时间复杂度：O(n * n)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int i = 0;
        int[] ale = new int[nums1.length];
        while (i < nums1.length){
            int j = 0;
            boolean in = false;
            while (j < nums2.length){
                if (nums1[i] == nums2[j] && j < nums2.length - 1){
                    int k = j + 1;
                    while (k < nums2.length){
                        if (nums1[i] < nums2[k]){
                            ale[i] = nums2[k];
                            in = true;
                            break;
                        }
                        k ++;
                    }
                    if (in){
                        break;
                    }
                }
                if (!in){
                    ale[i] = -1;
                }
                j ++;
            }
            i ++;
        }
        return ale;
    }

    /**
     * leetcode版本：
     * https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode/
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElementWithStack(int[] nums1, int[] nums2){
        int[] ale = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < nums2.length){
            //从stack中找到比num2[i]小的值，放入map,小值为key。
            while (!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
            i ++;
        }
        System.out.println(map.toString());
        int j = 0;
        while (j < nums1.length){
            ale[j] = map.get(nums1[j]) == null ? -1 : map.get(nums1[j]);
            j ++;
        }
        return ale;
    }
}
