package com.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/divisor-game/
 * 1025. 除数博弈
 */
public class DivisorGame {
    @Test
    public void test(){
        boolean b = divisorGame(2);
        System.out.println(b);
    }
    public boolean divisorGame(int N) {
        int x = N - 1;
        //回合数
        //anni: turn%2 == 0
        //bob: turn%2 == 1
        int turn = 0;
        while (0 < x && x < N){
            x = N - 1;
            if (turn % 2 == 0){
                //anni's turn
                while (x > 0 && N % x != 0){
                    x --;
                }
                if (x <= 0)
                    return false;
                N -= x;
                //anni回合结束
                turn ++;
            }else {
                //bob's turn
                while (x > 0 && N % x != 0){
                    x --;
                }
                if (x <= 0)
                    return true;
                N -= x;
                //bob回合结束
                turn ++;
            }
        }
        return false;
    }
}
