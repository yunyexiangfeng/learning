package com.leetcode.array;

import org.junit.Test;

/**
 * @Author: Administrator
 * @CreateDate: 2020/11/18 10:01
 * @Description: 1299. 将每个元素替换为右侧最大元素
 *
 *给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 *
 * 示例：
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 */
public class ReplaceElementsMaxRight {

    private int[] arr;

    @Test
    public void test(){
        int[] arr = {17,18,5,4,6,1};
        arr = replaceElements(arr);
        for (int i : arr){
            System.out.println(i);
        }
    }

    /**
     * 关键词：最右
     * 方法：逆序遍历
     * 用max记录最大值
     *
     * 时间复杂度:O(N)
     * 空间复杂度：O(1)
     * 注：这里res数据作为返回值，不算做额外空间，故空间复杂度为O(1)
     * @param arr 待替换数组
     * @return 已替换数组
     */
    private int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        if (arr.length > 0){
            int max = arr[arr.length - 1];
            for(int i = arr.length; i > 0; i --){
                res[i - 1] = max;
                max = Math.max(max, arr[i - 1]);
            }
            res[arr.length -1] = -1;
        }
        return res;
    }

}
