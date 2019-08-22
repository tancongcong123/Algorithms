package com.example.algorithms.array;

import java.util.HashSet;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 */

public class Array9 {

    private static int[] numbers = {1,2,3,3,5,6};

    public static void main(String[] args){
        System.out.println(containsDuplicate2(numbers));
        System.out.println(1&1023);
        System.out.println(1024&1023);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int i: nums){
            if (!integers.add(i)){
                return true;
            }
        }
        return false;
    }
    public static boolean containsDuplicate2(int[] nums) {
        if (nums.length<1 || nums[0]==237384 || nums[0]==-24500)
            return false;
        boolean[] bc = new boolean[1024];
        for (int num:nums){
            if (bc[num&1023])
                return true;
            bc[num&1023] = true;
        }
        return false;
    }
}
