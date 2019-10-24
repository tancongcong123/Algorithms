package com.example.algorithms.practice;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 */
public class Reverse {

    public static void main(String[] args){
//        System.out.println(reverse(-2147483648));
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        if (x>=Integer.MAX_VALUE || x<=Integer.MIN_VALUE){
            return 0;
        }
        int mark = x<0?-1:1;
        String res = String.valueOf(Math.abs(x));
        int result = 0;
        for (int i=0;i<res.length();i++){
            result += Integer.valueOf(res.substring(i, i+1))*Math.pow(10, i);
            if (result>=Integer.MAX_VALUE || result<=Integer.MIN_VALUE){
                return 0;
            }
        }
        return result*mark;
    }
}
