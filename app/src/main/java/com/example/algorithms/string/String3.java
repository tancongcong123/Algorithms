package com.example.algorithms.string;

import java.util.regex.Pattern;

/**
 * 查找字符串数组中的最长公共前缀
 * 所有输入只包含小写字母 a-z
 *
 * output:fl
 */
public class String3 {

    private static String[] a = {"flow", "flight", "fly"};

    public static void main(String[] args){
        System.out.println(longestCommonPrefix(a));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length<1){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        String pattern = "[a-z]*";
        String result = strs[0];
        boolean isNotMatched = true;
        while (isNotMatched){
            System.out.println("result=="+result);
            isNotMatched = false;
            for (int i=0;i<strs.length;i++){
                if (!Pattern.matches(pattern, strs[i])){
                    throw new RuntimeException("input must be a-z");
                }
                if (result.length()>strs[i].length() ||
                        !result.equals(strs[i].substring(0, result.length()))){
                    isNotMatched = true;
                    result = result.substring(0, result.length()-1);
                    break;
                }
            }
        }
        return result;
    }
}
