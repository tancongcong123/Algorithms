package com.example.algorithms.dynamicProgramming;

/**
 * 定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 */
public class MaxSubArray {

    public static void main(String[] args){
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4,8}));
        System.out.println(maxSubArray(new int[]{-2,-3,4,-1,-5,4}));
    }

    public static int maxSubArray(int[] nums){
        int sum=0;
        int currentMax=nums[0];
        int start = 0;
        int end = 0;
        for(int i=0;i<nums.length;i++){
            if(sum>=0){
                sum+=nums[i];
            }else{
                sum=nums[i];
                start = i;
            }
            if (currentMax<sum){
                end = i;
                currentMax=sum;
            }
            start = start>end?end:start;
        }
        System.out.println("start=="+start);
        System.out.println("end=="+end);
        return currentMax;
    }

    public static int maxSubArray2(int[] nums){
        if (nums==null || nums.length<1)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            int currentMax = nums[i];
            int sum = nums[i];
            for (int j=i+1;j<nums.length;j++){
                sum = sum+nums[j];
                currentMax = currentMax<sum?sum:currentMax;
            }
            max = max<currentMax?currentMax:max;
        }
        return max;
    }
}
