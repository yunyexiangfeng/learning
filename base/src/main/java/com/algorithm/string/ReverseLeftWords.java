package com.algorithm.string;

import org.junit.Test;

/**
 * Created by OY on 2020/4/11.
 */
public class ReverseLeftWords {
    @Test
    public void test(){
        System.out.println(reverseLeftWords("abcdefg", 2));
    }
    public String reverseLeftWords(String s, int n) {
        if (n > s.length() || n <= 0){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = n; i < chars.length; i ++){
            sb.append(chars[i]);
        }
        for (int i = 0; i < n; i ++){
            sb.append(chars[i]);
        }
        return sb.toString();

//        return s.substring(n) + s.substring(0,n);
    }
}
