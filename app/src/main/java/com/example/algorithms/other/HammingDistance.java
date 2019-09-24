package com.example.algorithms.other;

/**
 * 输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）
 */
public class HammingDistance {

    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(1^4));
        System.out.println(Integer.toBinaryString(15));
        System.out.println(hammingDistance(1,4));
    }

    public static int hammingDistance(int x, int y) {
        if (x==y)
            return 0;
        String s = Integer.toBinaryString(x^y);
        int res = 0;
        for (char c:s.toCharArray()){
            if (c=='1'){
                res++;
            }
        }
        return res;
    }

    public static int hammingDistance2(int x, int y) {
        if (x==y)
            return 0;
        return hammingDistanceOrder(Math.min(x,y),Math.max(x,y));
    }

    public static int hammingDistanceOrder(int min, int max) {
        int res = 0;
        String minStr = Integer.toBinaryString(min);
        String maxStr = Integer.toBinaryString(max);
        int minIndex = minStr.length()-1;
        int maxIndex = maxStr.length()-1;
        while (maxIndex>=0){
            if (minIndex<0){
                if (maxStr.charAt(maxIndex)=='1'){
                    res++;
                }
                maxIndex--;
            }else {
                if (maxStr.charAt(maxIndex)!=minStr.charAt(minIndex)){
                    res++;
                }
                maxIndex--;
                minIndex--;
            }
        }
        return res;
    }
}
