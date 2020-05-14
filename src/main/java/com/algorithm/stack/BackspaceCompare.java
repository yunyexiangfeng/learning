package com.algorithm.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by OY on 2020/4/28.
 */
public class BackspaceCompare {

    @Test
    public void test(){
        String s = "y#fo##f";
        String t = "y#f#o##f";
        System.out.println(backspaceCompare(s, t));

    }
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();

        for (char c : S.toCharArray()){
            if (c == '#'){
                if (!s.isEmpty()) s.pop();
            }else {
                s.push(c);
            }
        }
        for (char c : T.toCharArray()){
            if (c == '#'){
                if (!t.isEmpty()) t.pop();
            }else {
                t.push(c);
            }
        }
        //如果两个栈都为空，表示退格后s,t都为空字符串
        if(s.isEmpty() && t.isEmpty()){
            return true;
        }
        if (!s.isEmpty() && !t.isEmpty()){
            if (s.toString().equals(t.toString())){
                return true;
            }
        }
        return false;
    }
}
