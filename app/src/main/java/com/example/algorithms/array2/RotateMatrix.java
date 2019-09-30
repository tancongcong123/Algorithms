package com.example.algorithms.array2;

import com.example.algorithms.PrintUtils;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像
 * 将图像顺时针旋转 90 度
 *
 * ps:
 * 原地旋转图像,请不要使用另一个矩阵来旋转图像
 *
 * input
 * [[1,2,3],[4,5,6],[7,8,9]]
 * output
 * [[7,4,1],[8,5,2],[9,6,3]]
 */
public class RotateMatrix {

    private static int[][] chars = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

    public static void main(String[] args){
        System.out.println(PrintUtils.toString(chars));
        rotate(chars);
    }

    /**
     * 原地旋转
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        if (matrix==null || matrix.length==0)
            return;
        boolean[][] booleans = new boolean[matrix.length][matrix.length];
        for (int row=0;row<matrix.length;row++){
            for (int column=0;column<matrix.length;column++){
                if (!booleans[row][column]){
                    int temp = matrix[column][matrix.length-1-row];
                    matrix[column][matrix.length-1-row] = matrix[row][column];
                    matrix[row][column] = temp;
                    booleans[column][matrix.length-1-row] = true;
                    booleans[row][column] = true;
                }
            }
        }
        System.out.println(PrintUtils.toString(matrix));
    }

    /**
     * 新建数组存储
     * @param matrix
     */
    public static void rotate2(int[][] matrix) {
        if (matrix==null || matrix.length==0)
            return;
        int[][] res = new int[matrix.length][matrix.length];
        for (int row=0;row<matrix.length;row++){
            for (int column=0;column<matrix.length;column++){
                res[column][matrix.length-1-row] = matrix[row][column];
            }
        }
        System.out.println(PrintUtils.toString(res));
    }
}
