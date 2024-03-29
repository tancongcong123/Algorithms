package com.example.algorithms.practice;

import com.example.algorithms.PrintUtils;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 */
public class TwoSum {

    public static void main(String[] args){
        System.out.println(PrintUtils.toString(twoSum(new int[]{2, 7, 11, 15}, 17)));
        System.out.println(PrintUtils.toString(twoSum(new int[]{}, 17)));
        System.out.println(PrintUtils.toString(twoSum(new int[]{2}, 17)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums==null || nums.length<2)
            return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target-nums[i], i);
        }
        return new int[0];
    }
}
