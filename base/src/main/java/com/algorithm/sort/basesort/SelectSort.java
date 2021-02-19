package com.algorithm.sort.basesort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 选择排序
 * 1.从小到大
 *  以第i个数据作为标识，用(i + 1)--array.length中的数据与第一个数据进行对比，如果小，则交互
 * 2.从大到小
 *  以第i个数据作为标识，用(i + 1)--array.length中的数据与第一个数据进行对比，如果大，则交互
 * Created by OY on 2020/4/15.
 */
public class SelectSort {
    @Test
    public void test(){
        int[] array = new int[]{3,5,7,1,2,9,8};
        //计算排序时间
        long begin = System.currentTimeMillis();
        System.out.println("开始时间：" + begin);
        int[] result = selectSort(array);
        long end = System.currentTimeMillis();
        System.out.println("结束时间：" + end);
        System.out.println("排序时间：" + (end - begin));
        System.out.println("排序结果：" + Arrays.toString(result));
    }

    /**
     * 时间复杂度: O(n*n)
     * 空间复杂度: 临时变量temp O(1)
     * @param array
     * @return
     */
    public int[] selectSort(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length; i ++){
            temp = array[i];
            for (int j = i + 1; j < array.length; j ++){
                if (temp > array[j]){
                    array[i] = array[j];
                    array[j] = temp;
                    temp = array[i];
                }
            }
            System.out.println("第" + i +"轮排序结果：" + Arrays.toString(array));
        }
        return array;
    }
}
