package com.leetcode.matrix;

/**
 * https://leetcode-cn.com/problems/zero-matrix-lcci/
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 */
public class SetZeroes {

    public static void main(String[] args) {
//        [[1,1,1],[1,0,1],[1,1,1]]
//        [ [0,1,2,0],[3,4,5,2],[1,3,1,5]]
        /*int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };*/
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5},
        };
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        //复制数组
        int[][] cp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[0].length; j ++){
                cp[i][j] = matrix[i][j];
            }
        }
        System.out.println("before");
        print(cp);
        //清0
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[0].length; j ++){
                if (matrix[i][j] == 0){
                    for (int k = 0; k < matrix[i].length; k ++){
                        cp[i][k] = 0;
                    }
                    for (int m = 0; m < matrix.length; m ++){
                        cp[m][j] = 0;
                    }
                }
            }
        }
        //复制回原数组
        for (int i = 0; i < cp.length; i ++){
            for (int j = 0; j < cp[0].length; j ++){
                 matrix[i][j] = cp[i][j];
            }
        }
        System.out.println("after");
        print(matrix);
    }

    private static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[0].length; j ++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
