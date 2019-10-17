package com.example.algorithms.practice;

public class LengthOfLongestSubstring {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("b"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("dvadf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s==null || s.equals(""))
            return res;
        StringBuilder currentStr = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if (currentStr.toString().contains(s.substring(i, i+1))){
                res = res<currentStr.length()?currentStr.length():res;
                currentStr.delete(0, currentStr.toString().indexOf(s.substring(i, i+1))+1);
            }
            currentStr.append(s.substring(i, i+1));
        }
        res = res<currentStr.length()?currentStr.length():res;
        return res;
    }
}
