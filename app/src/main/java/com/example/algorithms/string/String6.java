package com.example.algorithms.string;

/**
 * 将数组中的0移动到末端
 * output:
 * [1,1,1,2,2,3,3,4,0,0]
 */

public class String6 {

    private static int[] numbers = {0,1,2,2,3,0,4,2};

    public static void main(String[] args){
        System.out.println(removeElement(numbers, 2));
    }
    public static int removeElement(int[] nums, int val) {
        if (nums==null || nums.length<1)
            return -1;
        int k=0;
        for (int i=0; i<nums.length;i++){
            if (nums[i]!=val){
                nums[k]=nums[i];
                k++;
            }
        }
        System.out.print("[");
        for (int i=0; i<k;i++){
            System.out.print(nums[i]+(i==(k-1)?"":","));
        }
        System.out.println("]");
        return k;
    }
}
