package com.example.algorithms.dynamicProgramming;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12
 */
public class Rob {

    public static void main(String[] args){
        System.out.println(rob2(new int[]{1,2,3,1}));
        System.out.println(rob2(new int[]{2,7,9,3,1}));
        System.out.println(rob2(new int[]{2,1,1,2}));
        System.out.println(rob2(new int[]{2,4,8,9,9,3}));
    }

    public static int rob2(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }else if (nums.length==1){
            return nums[0];
        }else if (nums.length==2){
            return Math.max(nums[0], nums[1]);
        }else {
            int[] result = new int[nums.length];
            result[0] = nums[0];//只有一家的情况下，只能抢这一家了
            result[1] = Math.max(nums[0], nums[1]);//有两家可选的情况下，抢价值最大的那一家
            for(int index=2; index < result.length; index++){
                result[index] = Math.max(nums[index] + result[index-2], result[index -1]);
            }
            return result[nums.length -1];
        }
    }

    public static int rob(int[] nums) {
        return solve(nums.length-1, nums);
    }

    public static int solve(int index, int[] nums){
        if(index < 0){
            return 0;
        }
        int max = Math.max(nums[index] + solve(index - 2, nums), solve(index - 1, nums));
        return max;
    }


}
