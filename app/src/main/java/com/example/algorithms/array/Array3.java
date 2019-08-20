package com.example.algorithms.array;

import com.example.algorithms.PrintUtils;

/**
 * 给定一个整数类型的数组 nums，表示一个非负整数，加一输出新的数值
 */
public class Array3 {

    // 1*1000+2*100+4*10+6*1
    private static int[] nums = {1,2,4,6};
//    private static int[] nums = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,5};

    public static void main(String[] args){
        System.out.print("plusOne=="+ PrintUtils.toString(plusOne(nums)));
    }

    private static int[] plusOne(int[] digits){
        long newNumber = array2number(digits)+1;
        return number2Array(newNumber);
    }

    private static long array2number(int[] digits){
        long result = 0;
        for (int i=0;i<digits.length;i++){
            result+=Math.pow(10, digits.length-1-i)*digits[i];
        }
        return result;
    }

    private static int[] number2Array(long number){
        String str = String.valueOf(number);
        int[] result = new int[str.length()];
        for (int i = 0;i<str.length();i++){
            result[i] = Integer.valueOf(str.substring(i, i+1));
        }
        return result;
    }

}
