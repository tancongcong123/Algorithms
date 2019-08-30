package com.example.algorithms.string;

import com.example.algorithms.PrintUtils;

public class String7 {

    private static char[] chars = {'h','e','l','l','o','e','v','e','r','y','o','n','e'};

    public static void main(String[] args){
        System.out.println(reverseWords("  a good   example"));
        System.out.println("-------------------");
        reverseString(chars);
        System.out.println("-------------------");
        reverseString2(chars);
    }

    public static String reverseWords(String s) {
        if (s==null)
            return "";
        s = s.replaceAll(" +", " ");
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=strings.length-1;i>=0;i--){
            if (strings[i].trim().equals(""))
                continue;
            stringBuilder.append(i==strings.length-1?"":" ");
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }

    public static void reverseString(char[] s) {
        long start = System.currentTimeMillis();
        helper(0, s.length-1, s);
        System.out.println("cost time="+(System.currentTimeMillis()-start));
        System.out.println(PrintUtils.toString(s));
    }
    private static void helper(int start, int last, char[] c){
        if (c==null || start>=last){
            return;
        }
        helper(start+1, last-1, c);
        char temp = c[start];
        c[start] = c[last];
        c[last] = temp;
    }

    public static void reverseString2(char[] s) {
        long start = System.currentTimeMillis();
        if (s==null)
            return;
        int i=0;
        int j=s.length-1;
        while (i<j){
            char temp= s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        System.out.println("cost time="+(System.currentTimeMillis()-start));
        System.out.println(PrintUtils.toString(s));
    }

    public static String reverseString3(char[] s) {
        if (s==null)
            return null;
        int i=0;
        int j=s.length-1;
        while (i<j){
            char temp= s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:s){
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
