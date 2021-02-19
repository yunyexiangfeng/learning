package com.algorithm.sort.basesort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 直接插入排序
 * Created by OY on 2020/4/16.
 */
public class InsertSort {

    @Test
    public void test(){

        int[] array = {3,5,7,1,2,9,8};
        int[] result = insertSort(array);
        System.out.println("排序后：" + Arrays.toString(result));
    }

    /**
     * 时间复杂度：O(n*n)
     * 空间复杂度：temp为额外空间 O(1)
     * @param array
     * @return
     */
    public int[] insertSort(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length - 1; i ++){
            //将array[i]数据保存到temp
            temp = array[i + 1];
            for (int j = i; j >= 0; j --){
                if (array[j] > temp){
                    //后移
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("第" + i + "轮循环：" + Arrays.toString(array));
        }
        return array;
    }
}
