package com.example.algorithms.string;

public class String7 {

    public static void main(String[] args){
        System.out.println(reverseWords("  a good   example"));
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
}
