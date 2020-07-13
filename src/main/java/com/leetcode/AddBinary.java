package com.leetcode;

import org.junit.Test;

public class AddBinary {
    @Test
    public void test(){
        System.out.println(addBinary("1010", "1011"));
    }
    public String addBinary(String a, String b) {
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        StringBuffer sb = new StringBuffer();
        int maxLen = Math.max(chars1.length, chars2.length);
        int minLen = Math.min(chars1.length, chars2.length);
        int add = 0;
        for (int i = maxLen - 1, j = minLen - 1; i >= 0 || j >= 0; i --, j --){
            if (a.length() > b.length()){
                if ((i - j) >= (maxLen - minLen)){
                    if (chars1[i] == '1' && chars2[j] == '1'){
                        add = 1;
                        sb.append(0);
                    }else if (chars1[i] == '1' || chars2[j] == '1'){
                        if (add == 1){
                            add = 0;
                            sb.append(0);
                        }else {
                            sb.append(1);
                        }
                    }else {
                        sb.append(0);
                    }
                }else {
                    if (chars1[i] == '1' && add == 1){
                        sb.append(0);
                    }else if(chars1[i] == '1' || add == 1){
                        if (add == 1){
                            sb.append(1);
                            add = 0;
                        }else {
                            sb.append(chars1[i] == '1');
                        }
                    }else {
                        sb.append(0);
                    }
                }
            }else if (a.length() < b.length()){
                if ((i - j) >= (maxLen - minLen)){
                    if (chars1[j] == '1' && chars2[i] == '1'){
                        add = 1;
                        sb.append(0);
                    }else if (chars1[j] == '1' || chars2[i] == '1'){
                        if (add == 1){
                            add = 0;
                            sb.append(0);
                        }else {
                            sb.append(1);
                        }
                    }else {
                        sb.append(0);
                    }
                }else {
                    if (chars2[i] == '1' && add == 1){
                        sb.append(0);
                    }else if(chars2[i] == '1' || add == 1){
                        if (add == 1){
                            sb.append(1);
                            add = 0;
                        }else {
                            sb.append(chars2[i] == '1');
                        }
                    }else {
                        sb.append(0);
                    }
                }
            }else {
                if (chars1[i] == '1' && chars2[j] == '1'){
                    add = 1;
                    sb.append(0);
                }else if (chars1[i] == '1' || chars2[j] == '1'){
                    if (add == 1){
                        add = 0;
                        sb.append(0);
                    }else {
                        sb.append(1);
                    }
                }else {
                    sb.append(0);
                }
            }
        }
        return sb.toString();
    }
}
