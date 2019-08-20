package com.example.algorithms.string;

/**
 * 给定两个二进制字符串，返回他们的和
 */
public class String2 {

    private static String a = "heyyl";
    private static String b = "ll";

    public static void main(String[] args){
        System.out.println(strStr(a, b));
    }

    public static int strStr(String haystack, String needle) {
        if (needle==null||needle.equals("")){
            return 0;
        }
        int index = -1;
        int needleSize = needle.length();
        for (int i=0;i<haystack.length();i++){
            if (i+needleSize>haystack.length()){
                return -1;
            }
            if (needle.equals(haystack.substring(i,needleSize+i))){
                return i;
            }
        }
        return index;
    }
}
