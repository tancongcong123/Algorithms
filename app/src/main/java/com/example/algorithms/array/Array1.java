package com.example.algorithms.array;

/**
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍
 */
public class Array1 {

    private static int[] nums = {1,2,3,6,6};

    public static void main(String[] args){
        System.out.println("getDominantIndex=="+getDominantIndex(nums));
    }

    private static int getDominantIndex(int[] nums){
        int max = getMax(nums);
        int maxIndex = -1;
        for (int i=0;i<nums.length;i++){
            if (max==nums[i]){
                maxIndex = maxIndex>-1?maxIndex:i;
                continue;
            }
            if (0==nums[i]){
                continue;
            }
            if (max/nums[i]<2)
                return -1;
        }
        return maxIndex;
    }

    private static int getMax(int[] nums){
        int max = 0;
        for (int i=0;i<nums.length;i++){
            max = max<nums[i]?nums[i]:max;
        }
        return max;
    }
}
