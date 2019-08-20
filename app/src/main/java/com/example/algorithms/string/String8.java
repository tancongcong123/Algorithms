package com.example.algorithms.string;

public class String8 {

    public static void main(String[] args){
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        if (s==null)
            return "";
        s = s.replace(" +", "");
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<strings.length;i++){
            if (strings[i].trim().equals(""))
                continue;
            stringBuilder.append(i==0?"":" ");
            stringBuilder.append(getReverseWord(strings[i]));
        }
        return stringBuilder.toString();
    }

    private static String getReverseWord(String word){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=word.length()-1;i>=0;i--){
            stringBuilder.append(word.substring(i,i+1));
        }
        return stringBuilder.toString();
    }
}
