package com.example.algorithms.array;

import java.util.Arrays;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法
 * 中心索引：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和
 */
public class Array2 {

    private static int[] nums = {1,7,3,6,5,6};
    private static int[] nums2 = {1,2,4,6};

    public static void main(String[] args){
        System.out.println("getMiddleIndex=="+getMiddleIndex(nums));
        System.out.println("getMiddleIndex=="+getMiddleIndex(nums2));
    }

    private static int getMiddleIndex(int[] numbers){
        for (int i=0;i<numbers.length;i++){
            int left = getSubSum(Arrays.copyOfRange(numbers, 0, i));
            int right = 0;
            if (i<=numbers.length-1){
                right = getSubSum(Arrays.copyOfRange(numbers, i+1, numbers.length));
            }
            if (left==right){
                return i;
            }
        }
        return -1;
    }

    private static int getSubSum(int[] nums){
        int sum = 0;
        for (int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        return sum;
    }
}
