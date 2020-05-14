package com.algorithm.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by OY on 2020/4/23.
 */
public class CalPoints {

    @Test
    public void test(){
        String[] str = {"5","2","C","D","+"};
        int i = calPoints(str);
        System.out.println(i);
    }
    public int calPoints(String[] ops) {
        Stack<String> stack = new Stack<>();
        int sum = 0;
        for (String s : ops){
            int score = 0;
            switch (s){
                case "+":
                    if (stack.isEmpty()){
                        continue;
                    }
                    int v1 = Integer.valueOf(stack.pop());
                    int v2 = Integer.valueOf(stack.peek());
                    score = v1 + v2;
                    stack.push(String.valueOf(v1));
                    break;
                case "D":
                    if (stack.isEmpty()){
                        continue;
                    }
                    int v3 = Integer.valueOf(stack.peek());
                    score = 2 * v3;
                    break;
                case "C":
                    String v4 = stack.pop();
                    sum -= Integer.valueOf(v4);
                    continue;
                default:
                    score = Integer.valueOf(s);
            }
            System.out.println("score: " + score);
            stack.push(String.valueOf(score));
            sum += score;
        }
        return sum;
    }
}
