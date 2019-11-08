package com.example.algorithms.practice;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 * 你能不将整数转为字符串来解决这个问题吗
 */
public class IsPalindrome {

    public static void main(String[] args){
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(100));
        System.out.println(isPalindrome(Integer.MAX_VALUE));
    }

    public static boolean isPalindrome(int x) {
        if (x<0 || x>=Integer.MAX_VALUE)
            return false;
        int res = 0;
        int old = x;
        while (x>0){
            res = res*10+(x%10);
            x = x/10;
        }
        return old==res;
    }
}
