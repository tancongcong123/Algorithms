package com.example.algorithms.math;

/**
 * 给定一个整数，写一个函数来判断它是否是 2 的幂次方
 */
public class PowerOfTwo {

    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(128));
        System.out.println(Integer.toBinaryString(127));
        System.out.println(Integer.toBinaryString(126));
        System.out.println(128&127);
        System.out.println(127&126);

        System.out.println(isPowerOfTwo(2187));
        System.out.println(isPowerOfTwo(256));
    }

    /**
     * step1:
     * 整数乘以2，都相当于向左移动了一位，而2的0次幂为1，所以2的n次幂就是1向左移动n位。
     * 这样，2的幂的特征就是二进制表示只有最高位为1，其他位均为0。
     * 那么，我们只要判断一个数的二进制表示只有一个1，那么它就是2的幂
     * step2:
     * n为整数，则n & (n - 1)可以消除n二进制表示的最低位的1，
     * 这个方法可以用来统计一个数二进制中1的个数，当然也可以用来判断是否为2的幂
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return (n>0)&&(n&(n-1))==0;
    }
}
