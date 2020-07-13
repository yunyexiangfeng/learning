package com.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 * 面试题 17.16. 按摩师
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 *
 * 1.dynamic programming
 * 2.迭代法
 */
public class Massage {
    @Test
    public void test(){
        int[] array = {2,1,4,5,3,1,1,3};
//        System.out.println(message(array));


        int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        String convert = stringConverter.convert(2);
        System.out.println(convert);
    }

    /**
     * 暴力法
     * @param array
     * @return
     */
    public int message(int[] array){
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0, j = 1; j < array.length; i += 2, j += 2){
            sum1 += array[i];
            sum2 += array[j];
        }
        return Math.max(sum1, sum2);
    }
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
