package com.example.algorithms.array;

import com.example.algorithms.PrintUtils;

/**
 * 将数组中的0移动到末端
 * output:
 * [1,1,1,2,2,3,3,4,0,0]
 */

public class Array7 {

    private static int[] numbers = {0,0,1,1,1,2,2,3,3,4};

    public static void main(String[] args){
        moveZeroes(numbers);
    }

    public static void moveZeroes(int[] nums) {
        if (nums==null)
            return;
        int length = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                continue;
            }else {
                nums[length] = nums[i];
                length++;
            }
        }
        for (int i=length;i<nums.length;i++){
            nums[i]=0;
        }
        System.out.println(PrintUtils.toString(nums));
    }
}
