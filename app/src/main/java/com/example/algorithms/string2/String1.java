package com.example.algorithms.string2;

import java.util.HashMap;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class String1 {

    private static String s = "leetcode";

    public static void main(String[] args){
        System.out.println(firstUniqChar(s));
        System.out.println(firstUniqChar2(s));
    }

    public static int firstUniqChar(String s) {
        if (s==null || s.equals(""))
            return -1;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i=0;i<s.length();i++){
            Character character = s.charAt(i);
            if (hashMap.containsKey(character)){
                hashMap.put(character, hashMap.get(character)+1);
            }else {
                hashMap.put(character, 1);
            }
        }
        int result = -1;
        for (Character key:hashMap.keySet()){
            if (hashMap.get(key)==1){
                int charIndex = s.indexOf(key);
                if (result==-1){
                    result = charIndex;
                }else {
                    result = result<charIndex?result:charIndex;
                }
            }
        }
        return result;
    }

    public static int firstUniqChar2(String s) {
        // 在给出的字符串中查找26个英文字母第一次和最后一次出现的位置
        int start;
        int end;
        int result = s.length();
        for(char ch = 'a'; ch <= 'z'; ch++) {
            start = s.indexOf(ch);
            end = s.lastIndexOf(ch);
            if(start == end && start != -1) {
                result = Math.min(result,start);
            }
        }
        if(result == s.length()) {
            return -1;
        }
        return result;
    }
}
