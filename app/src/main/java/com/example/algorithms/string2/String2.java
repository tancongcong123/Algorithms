package com.example.algorithms.string2;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 * 字母异位词是指由相同的字母按照不同的顺序组成的单词
 *
 * input: s = "anagram", t = "nagaram"
 * output: true
 */
public class String2 {

    public static void main(String[] args){
        System.out.println(isAnagram("anagram","nagrram"));
        System.out.println(isAnagram2("anagram","nagrram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s==null || t==null)
            return false;
        if (s.length()!=t.length())
            return false;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex<s.length() && tIndex<t.length()){
            if (sChar[sIndex] != tChar[tIndex]){
                return false;
            }
            sIndex++;
            tIndex++;
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;
        int has[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            has[s.charAt(i) - 'a']++;
            has[t.charAt(i) - 'a']--;
        }
        for (int i : has)
            if (i != 0) return false;
        return true;
    }
}
