package com.example.algorithms.string2;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * 7.     13112221
 * 8.     1113213211
 */
public class String5 {

    public static void main(String[] args){
        System.out.println(countAndSay(8));
    }

    public static String countAndSay(int n) {
        if (n>1){
            return getSays(countAndSay(n-1));
        }else {
            return "1";
        }
    }

    private static String getSays(String s){
        StringBuilder stringBuilder = new StringBuilder();
        String current = s.substring(0,1);
        int start =0;
        for (int i=0;i<s.length();i++){
            if (!s.substring(i,i+1).equals(current)){
                stringBuilder.append((i-start)+current);
                start = i;
                current = s.substring(i, i+1);
            }
            if (i==s.length()-1){
                stringBuilder.append((i-start+1)+current);
            }
        }
        return stringBuilder.toString();
    }
}
