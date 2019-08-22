package com.example.algorithms.array2;

import com.example.algorithms.PrintUtils;

import java.util.Arrays;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
 */
public class Array1 {

    private static int[] nums = {2,2,1};
    private static int[] nums2 = {4,1,2,1,2};

    public static void main(String[] args){
        System.out.println("singleNumber=="+singleNumber2(nums));
        System.out.println("specialNum=="+(2^2));
        System.out.println("specialNum=="+(2^2^4));
    }

    /**
     * 异或
     * a^=b相当于：a=a^b
     * 按位对比，相同取0，不同取1
     * 通过一直异或下去，那些double的就变为0，最后就剩下那个单着的了
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        int specialNum = nums[0];
        for(int i = 1; i < nums.length; i++){
            specialNum ^= nums[i];
        }
        return specialNum;
    }

    private static int singleNumber(int[] nums){
        if (nums.length==1)
            return nums[0];
        Arrays.sort(nums);
        if (nums[0]!=nums[1]){
            return nums[0];
        }else {
            for (int i=1;i<nums.length;i++){
                if (i==nums.length-1){
                    return nums[nums.length-1];
                }
                if (i%2==1 && nums[i]!=nums[i-1]){
                    return nums[i-1];
                }
            }
        }
        return 0;
    }
}
