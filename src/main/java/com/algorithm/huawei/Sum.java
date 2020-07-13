package com.algorithm.huawei;

import java.util.HashMap;
import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {1,1,2,3};
        int[] b = {1,2,3,3};
        int i = sum(a,b,2);
        System.out.println(i);
    }

    public static int sum(int[] a, int[] b, int k){
        int sum = 0;
        //第m对
        int m = 0;
        HashMap<Integer, Integer> mapA = new HashMap();
        HashMap<Integer, Integer> mapB = new HashMap();
        while (m < k){
            if(m == 0){
                sum += a[m] + b[m];
                mapA.put(m, sum);
                mapB.put(m, sum);
            }else {
                if (a[m] <= b[m]){
                    for (int i = 0; i < m; i ++){
                        if (mapA.get(m) == null || mapA.get(m) < (a[m] + b[i])){
                            sum += a[m] + b[i];
                            mapA.put(m, a[m] + b[i]);
                            break;
                        }
                    }
                }
                if (a[m] > b[m]){
                    for (int i = 0; i < m; i ++){
                        if (mapB.get(m) == null || mapB.get(m) < (b[m] + a[i])){
                            sum += b[m] + a[i];
                            mapB.put(m, b[m] + a[i]);
                            break;
                        }
                    }
                }
            }
            m ++;
        }
        return sum;
    }
}
