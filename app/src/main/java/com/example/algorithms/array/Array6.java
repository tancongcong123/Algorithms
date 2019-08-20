package com.example.algorithms.array;

import com.example.algorithms.PrintUtils;

/**
 * 数组去重
 * output:
 * [0,1,2,3,4]
 * 5
 */
public class Array6 {

    private static int[] numbers = {0,0,1,1,1,2,2,3,3,4};

    public static void main(String[] args){
        System.out.println(removeDuplicates(numbers));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums==null)
            return 0;
        int length = 0;
        for (int i=0;i<nums.length;i++){
            boolean isContain = false;
            for (int k=0;k<length;k++){
                if (nums[i]==nums[k]){
                    isContain = true;
                    break;
                }
            }
            if (isContain){
                continue;
            }else {
                nums[length] = nums[i];
                length++;
            }
        }
        System.out.println(PrintUtils.toString(nums, length));
        return length;
    }
}
