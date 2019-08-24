package com.example.algorithms.array2;

import com.example.algorithms.PrintUtils;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 */
public class Array3 {

    private static int[] nums = {2, 7, 11, 15};

    public static void main(String[] args){
        System.out.println(PrintUtils.toString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums==null || nums.length<1)
            return new int[0];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (hashMap.containsKey(target-nums[i])){
                return new int[]{hashMap.get(target-nums[i]),i};
            }else {
                hashMap.put(nums[i],i);
            }
        }
        return new int[0];
    }
    public static int[] twoSum2(int[] nums, int target) {
        if (nums==null || nums.length<1)
            return new int[0];
        int index = 0;
        int fastIndex = index+1;
        while (fastIndex<nums.length){
            if (nums[index]+nums[fastIndex]==target)
                return new int[]{index, fastIndex};
            if (fastIndex==nums.length-1){
                index++;
                if (index>=fastIndex){
                    return new int[0];
                }else {
                    fastIndex = index+1;
                }
            }else {
                fastIndex++;
            }
        }
        return new int[0];
    }
}
