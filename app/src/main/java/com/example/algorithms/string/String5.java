package com.example.algorithms.string;

import com.example.algorithms.PrintUtils;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2
 * 返回的下标值（index1 和 index2）不是从零开始的。
 */
public class String5 {

    static int[] numbers = {2, 7, 11, 15};

    public static void main(String[] args){
        System.out.println(PrintUtils.toString(twoSum(numbers, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers==null || numbers.length<2){
            return new int[0];
        }
        for (int i=0;i<numbers.length;i++){
            for (int j=i+1;j<numbers.length;j++){
                if (numbers[i]+numbers[j]==target){
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }
}
