package com.example.algorithms.array;

import com.example.algorithms.PrintUtils;

/**
 * 给定一个整数类型的数组 nums，表示一个非负整数，加一输出新的数值
 */
public class Array3 {

    // 1*1000+2*100+4*10+6*1
    private static int[] nums = {9};
//    private static int[] nums = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,5};

    public static void main(String[] args){
        System.out.print("plusOne=="+ PrintUtils.toString(plusOne(nums)));
    }

    private static int[] plusOne(int[] digits){
        int reminder = 0;
        int index = digits.length-1;
        while (index>=0){
            int currentNumber = digits[index];
            if (currentNumber>8){
                reminder=1;
                index--;
            }else {
                digits[index] = (currentNumber+1);
                return digits;
            }
        }
        if (reminder==0)
            return digits;
        int[] result = new int[digits.length+1];
        result[0]=1;
        return result;
    }

}
