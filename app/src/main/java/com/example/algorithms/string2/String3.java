package com.example.algorithms.string2;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
 *
 * input: "A man, a plan, a canal: Panama"
 * output: true
 */
public class String3 {

    public static void main(String[] args){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    /**
     * 1 剔除非字母和数字元素
     * 2 循环比对
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]*","").toUpperCase();
        System.out.println(s);
        int frontIndex = 0;
        int backIndex = s.length()-1;
        while (frontIndex<backIndex){
            if (!s.substring(frontIndex, frontIndex+1).equals(s.substring(backIndex, backIndex+1)))
                return false;
            frontIndex++;
            backIndex--;
        }
        return true;
    }
}
