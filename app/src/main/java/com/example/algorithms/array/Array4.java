package com.example.algorithms.array;

import com.example.algorithms.PrintUtils;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素
 *
 * original:{{1,2,3},{4,5,6},{7,8,9}}
 * output:[1,2,4,7,5,3,6,8,9]
 */
public class Array4 {

    private static int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    private static int row = 0;
    private static int column = 0;
    private static boolean up = true;

    public static void main(String[] args) {
        System.out.println(PrintUtils.toString(findDiagonalOrder(matrix)));

    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix==null || matrix.length<1 || matrix[0].length<1){
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] result = new int[rows*columns];
        int currentIndex = 0;
        while (row<rows && column<columns){
            if (up){
                result[currentIndex] = matrix[row][column];
                if (column==columns-1){
                    up=false;
                    row = row+1;
                }else if (row==0){
                    up=false;
                    column = column+1;
                }else {
                    row = row-1;
                    column = column+1;
                }
            }else {
                result[currentIndex] = matrix[row][column];
                if (row==rows-1){
                    up=true;
                    column = column+1;
                }else if (column==0){
                    up=true;
                    row = row+1;
                }else {
                    row = row+1;
                    column = column-1;
                }
            }
            currentIndex++;
        }
        return result;
    }
}
