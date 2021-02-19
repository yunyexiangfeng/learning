package com.algorithm.huawei;

public class SubString {

    public static void main(String[] args) {
    }
    private int subString(String s, int k){
        char[] chars = s.toCharArray();
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i ++){
            for (int j = i + 1; j < chars.length; j ++){
                if (chars[j] == 'a' || chars[j] == 'o' || chars[j] == 'e'
                        || chars[j] == 'i' || chars[j] == 'u'){
                    count ++;
                    if (count == k){
                        for (int m = i; m < j; m ++){
                            sb.append(chars[m]);
                        }
                    }
                }
            }
        }
        return count;
    }
}
