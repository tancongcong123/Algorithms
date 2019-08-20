package com.example.algorithms.string;

/**
 * 给定两个二进制字符串，返回他们的和
 */
public class String1 {

    private static String a = "1010";
    private static String b = "1011";

    public static void main(String[] args){
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        int result = binary2Int(a)+binary2Int(b);
        return Integer.toBinaryString(result);
    }

    private static int binary2Int(String str){
        int result = 0;
        for (int i=0;i<str.length();i++){
            int s = Integer.valueOf(str.substring(i, i+1));
            if (s==0||s==1){
                if (s==1)
                    result += Math.pow(2,str.length()-i-1);
            }else {
                throw new RuntimeException("only should contains 0 or 1");
            }
        }
        return result;
    }
}
