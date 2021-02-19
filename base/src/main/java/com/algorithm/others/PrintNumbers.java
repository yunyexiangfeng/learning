package com.algorithm.others;

import org.junit.Test;

/**
 * Created by OY on 2020/4/12.
 * 按顺序打印出从 1 到最大的 n 位十进制数
 */
public class PrintNumbers {

    @Test
    public void test(){
        int[] a = printNumbers(2);
        for (int i = 0; i < a.length; i ++){
            System.out.println(a[i]);
        }
    }

    /**
     * key:
     *  如何根据输入的正整数n，计算出 n位 正整数
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
        //判断位数是否超出int类型长度
        if(n <= 0 || n > 32){
            return new int[0];
        }
        int k = 1;
        for (int i = 0; i < n; i ++){
            k = k * 10;
        }
        int a[] = new int[k - 1];
        for (int i = 0; i < k -1; i ++){
            a[i] = i + 1;
        }
        return a;
    }
}
