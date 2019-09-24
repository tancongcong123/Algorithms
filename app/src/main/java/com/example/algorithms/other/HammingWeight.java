package com.example.algorithms.other;

/**
 * 输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）
 */
public class HammingWeight {

    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(3));
        System.out.println(hammingWeight(3));
        System.out.println(hammingWeight2(3));
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(hammingWeight(-3));
        System.out.println(hammingWeight2(-3));
    }

    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0;
        for (char c:s.toCharArray()){
            if (c=='1'){
                res++;
            }
        }
        return res;
    }

    public static int hammingWeight2(int n) {
        int s=0;
        while(n!=0)
        {
            s++;
            n=n&(n-1);
        }
        return s;
    }
}
