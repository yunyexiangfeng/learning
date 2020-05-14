package com.algorithm.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by OY on 2020/4/22.
 */
public class RemoveDuplicates {
    @Test
    public void test(){

        String result = removeDuplicates("abbaca");
        System.out.println(result);
    }

    public String removeDuplicates(String s) {
        if (s == null){
            return null;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (char c : chars){
            if (stack.isEmpty()){
                stack.push(c);
                continue;
            }
            Character pop = stack.pop();
            if (pop != null && pop.equals(c)){
                continue;
            }
            stack.push(pop);
            stack.push(c);
        }
        StringBuffer sb = new StringBuffer();
        stack.forEach(character -> {
            sb.append(character);
        });
        return sb.toString();
    }
}
