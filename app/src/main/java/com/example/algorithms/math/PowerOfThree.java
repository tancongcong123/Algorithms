package com.example.algorithms.math;

import static java.lang.Math.log;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方
 */
public class PowerOfThree {

    public static void main(String[] args){
        System.out.println(isPowerOfThree(2187));
        System.out.println(isPowerOfThree2(2187));
    }

    public static boolean isPowerOfThree(int n) {
        if (n<=0)
            return false;
        while (true){
            if (n==1){
                return true;
            }
            if (n%3==0){
                n=n/3;
            }else {
                return false;
            }
        }
    }

    /**
     * 不使用循环或者递归
     * N=Integer.MAX_VALUE
     * 如果n小于N且是N的约数，那么其一定是3的幂
     * @param n
     * @return
     */
    public static boolean isPowerOfThree2(int n) {
        if(n<=0) return false;
        int max = (int) Math.pow(3, (int) (log(Integer.MAX_VALUE) / log(3)));
        return (max % n == 0);
    }
}
