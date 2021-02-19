package com.algorithm.sort;

/**
 * @version 1.0
 * @ProjectName: fremer
 * @Package: com.ham.han.fremer.algorithm.sort
 * @ClassName: SortArrayByParityII
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2019/11/20 20:15
 *
 *按奇偶排序数组
 *
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 */
public class SortArrayByParityII {

    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     * @param A
     * @return
     */
    public static int[] solutionOne(int[] A){
        if(A.length < 2){
            return A;
        }
        int tmp;
        for(int i = 0; i < A.length; i ++){
            if(A[i] % 2 == 0 && i % 2 == 0){
                continue;
            }
            if(A[i] % 2 == 1 && i % 2 == 1){
                continue;
            }
            if(A[i] % 2 == 0 && i % 2 == 1){
                for(int j = i + 1; j < A.length; j ++){
                    if(A[j] % 2 == 1 && j % 2 == 0){
                        tmp = A[i];
                        A[i] = A[j];
                        A[j] = tmp;
                        break;
                    }
                }
                continue;
            }
            if(A[i] % 2 == 1 && i % 2 == 0){
                for(int j = i + 1; j < A.length; j ++){
                    if(A[j] % 2 == 0 && j % 2 == 1){
                        tmp = A[i];
                        A[i] = A[j];
                        A[j] = tmp;
                        break;
                    }
                }
            }
        }
        return A;
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N) odd + even
     * @param A
     * @return
     */
    public static int[] solutionTwo(int[] A){
        if(A.length < 2){
            return A;
        }
        int[] odd = new int[A.length/2];
        int[] even = new int[A.length/2];
        //一遍循环，将奇数和偶数分别放入不同数组中
        int k = 0;
        int m = 0;
        for (int i = 0; i < A.length; i ++){
            if(A[i] % 2 == 1){
                odd[k] = A[i];
                k ++;
            }
            if(A[i] % 2 == 0){
                even[m] = A[i];
                m ++;
            }
        }
        //将奇数放回数组
        for (int i = 0; i < odd.length; i ++){
            A[i * 2 + 1] = odd[i];
        }
        //将偶数放回数组
        for (int i = 0; i < even.length; i ++){
            A[i * 2] = even[i];
        }
        return A;
    }


    /**
     *时间复杂度：O(N)
     *      为什么时间复杂度是O(N),而不是(N/2) * (N/2)
     *空间复杂度：O(N)
     * @param A
     * @return
     */
    public static int[] solutionThree(int[] A){
        if(A.length < 2){
            return A;
        }
        int m = 1;//奇数指针
        int k = 0;//偶数指针
        int tmp;//
        for (; k < A.length; k += 2){
            //索引为偶数时，值为奇数，则遍历，对索引为奇数值为偶数，进行交换
            if (A[k] % 2 == 1){
                while (A[m] % 2 == 1){
                    m += 2;
                }
                //交换
                tmp = A[m];
                A[m] = A[k];
                A[k] = tmp;
            }
        }
        return A;
    }
}
