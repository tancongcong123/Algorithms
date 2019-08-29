package com.example.algorithms.array2;

import com.example.algorithms.PrintUtils;
import com.example.algorithms.array.Array5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像 将图像顺时针旋转 90 度
 *
 * 给定 matrix =
 * [
 *   [1,2,3,4],
 *   [5,6,7,8],
 *   [9,10,11,12]
 *   [13,14,15,16]
 * ]
 *
 * out:
 * [
 *   [13,9,5,1],
 *   [14,10,6,2],
 *   [15,11,7,3]
 *   [16,12,8,4]
 * ]
 */
public class Array4 {

    private static int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

    public static void main(String[] args){
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        if (matrix==null)
            return;
        int rows = matrix.length;
        int tier = (matrix.length-1)/2+1;
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<tier;i++){
            for (int j = i; j < rows - i; j++)// 左上到右上
                list.add(matrix[i][j]);
            for (int k = i + 1; k < rows - i; k++)// 右上到右下
                list.add(matrix[k][rows - i - 1]);
            for (int o = rows - i - 1; o > i; o--)// 右下到左下
                list.add(matrix[rows - i - 1][o - 1]);
            for (int p = rows - i - 2; p > i; p--)// 左下到右上
                list.add(matrix[p][i]);
        }
        System.out.println("list="+PrintUtils.toString(list));
        Array5.rotate(list, rows-1);

    }
}
