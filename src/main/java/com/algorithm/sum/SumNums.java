package com.algorithm.sum;

import org.junit.Test;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）
 * 难度：Mid
 * Created by OY on 2020/4/20.
 */
public class SumNums {

    @Test
    public void test(){
//        int sum = sumNums(3);
//        int sum = sumNumsCirculate(3);
//        int sum = sumNumsRecursion(3);
        int sum = sumNumsLogicAnd(3);
        System.out.println(sum);
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public int sumNumsRecursion(int n) {
        int sum = n;
        if (n > 1){
            sum = sum + sumNumsRecursion(n - 1);
        }
        return sum;
    }

    /**
     * 求和公式
     * @param n
     * @return
     */
    public int sumNums(int n){
        return n * (n + 1) / 2;
    }

    /**
     * 循环
     * @param n
     * @return
     */
    public int sumNumsCirculate(int n){
        int sum = 0;
        int count = 1;
        while (count <= n){
            sum = sum + count;
            count ++;
        }
        return sum;
    }

    int res = 0;

    /**
     * 逻辑与/或/非 的短路效果
     * @param n
     * @return
     */
    public int sumNumsLogicAnd(int n){
        //如果n > 1满足条件，才会继续sumNumsLogicAnd递归
        boolean x = n > 1 && sumNumsLogicAnd(n - 1) > 0;
//        res = res + n;

        res += n;
        return res;
    }
}
