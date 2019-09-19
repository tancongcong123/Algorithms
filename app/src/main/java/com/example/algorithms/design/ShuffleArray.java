package com.example.algorithms.design;

import com.example.algorithms.PrintUtils;

/**
 * 打乱一个没有重复元素的数组
 */
public class ShuffleArray {

    private static Solution solution;

    public static void main(String[] args){
        solution = new Solution(new int[]{1,2,3});
        System.out.println(PrintUtils.toString(solution.shuffle()));
        System.out.println(PrintUtils.toString(solution.reset()));
    }
}
