package com.example.algorithms.array;

import com.example.algorithms.PrintUtils;

import java.util.List;

/**
 * 旋转数组
 * output：
 * [7,1,2,3,4,5,6]
 * [6,7,1,2,3,4,5]
 *
 */
public class Array5 {

    private static int[] numbers = {1,2,3,4,5,6,7};

    public static void main(String[] args){
        rotate(numbers, 2);
    }

    public static void rotate(int[] nums, int k) {
        for(int i=0;i<k;i++){
            int preLast = nums[nums.length-1];
            for(int j=0;j<nums.length;j++){
                int temp = nums[j];
                nums[j] = preLast;
                preLast = temp;
            }
        }
        System.out.println(PrintUtils.toString(nums));
    }

    public static void rotate(List<Integer> nums, int k) {
        for(int i=0;i<k;i++){
            int preLast = nums.get(nums.size()-1);
            for(int j=0;j<nums.size();j++){
                int temp = nums.get(j);
                nums.set(j, preLast);
                preLast = temp;
            }
        }
        System.out.println(PrintUtils.toString(nums));
    }
}
