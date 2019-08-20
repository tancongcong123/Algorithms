package com.example.algorithms;

import java.util.List;

public class PrintUtils {

    public static String toString(int[] c){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int a=0;a<c.length;a++){
            stringBuilder.append(c[a]);
            if (a!=c.length-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String toString(int[] c, int length){
        if (length>c.length)
            length=c.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int a=0;a<length;a++){
            stringBuilder.append(c[a]);
            if (a!=c.length-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String toString(char[] c){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int a=0;a<c.length;a++){
            stringBuilder.append(c[a]);
            if (a!=c.length-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String toString(List c){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int a=0;a<c.size();a++){
            stringBuilder.append(c.get(a));
            if (a!=c.size()-1){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}