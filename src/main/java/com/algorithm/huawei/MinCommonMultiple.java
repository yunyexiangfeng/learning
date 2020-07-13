package com.algorithm.huawei;

import org.junit.Test;

import java.util.Scanner;

public class MinCommonMultiple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        multiple(a, b);
    }
    public static int minCommonMultiple(int a, int b){
        if(a < b){
            return multiple(a, b);
        }else {
            return multiple(b, a);
        }
    }
    public static int multiple(int a, int b){
        for (int i = 1; i <= b; i ++){
            if((a * i) % b == 0){
                return a * i;
            }
        }
        return 0;
    }
}
