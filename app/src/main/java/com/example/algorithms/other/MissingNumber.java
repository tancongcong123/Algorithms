package com.example.algorithms.other;

import java.util.Arrays;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，
 * 找出 0 .. n 中没有出现在序列中的那个数
 */
public class MissingNumber {

    public static void main(String[] args){
        System.out.println(missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber(new int[]{8,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber(new int[]{6,3,2,5,7,0,1}));

        System.out.println(missingNumber2(new int[]{3,0,1}));
        System.out.println(missingNumber2(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber2(new int[]{8,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber2(new int[]{6,3,2,5,7,0,1}));
    }

    public static int missingNumber(int[] nums) {
        if (nums==null){
            return 0;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    public static int missingNumber2(int[] nums) {
        if (nums==null){
            return 0;
        }
        Arrays.sort(nums);
        if (nums[nums.length-1]<nums.length){
            return nums.length;
        }
        for (int i=0;i<nums.length+1;i++){
            if (nums[i]>i){
                return nums[i]-1;
            }
        }
        return -1;
    }
}
