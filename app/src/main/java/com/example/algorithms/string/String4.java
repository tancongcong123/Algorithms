package com.example.algorithms.string;

import com.example.algorithms.PrintUtils;

/**
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从1 到 n 的 min(ai, bi) 总和最大
 */
public class String4 {

    static int[] numbers = {1,4,3,2};

    public static void main(String[] args){
        System.out.println(arrayPairSum(numbers));
    }

    public static int arrayPairSum(int[] nums) {
        int result = 0;
        sortArray(nums);
        for (int i=0;i<nums.length;i++){
            if (i%2==0){
                result+=nums[i];
            }
        }
        return result;
    }

    private static int[] sortArray(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if (nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
