package com.example.algorithms;

import com.example.algorithms.linkedList.ListNode;
import com.example.algorithms.linkedList.ListNode2;

import java.util.List;

public class PrintUtils {

    public static String toString(int[][] c){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[\n");
        for (int k=0;k<c.length;k++){
            stringBuilder.append("  [");
            for (int a=0;a<c[k].length;a++){
                stringBuilder.append(c[k][a]);
                if (a!=c[k].length-1){
                    stringBuilder.append(",");
                }
            }
            if (k==c.length-1){
                stringBuilder.append("]");
            }else {
                stringBuilder.append("],\n");
            }
        }
        stringBuilder.append("\n]");
        return stringBuilder.toString();
    }

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

    public static String linked2String(ListNode node){
        StringBuilder stringBuilder = new StringBuilder();
        while (node!=null){
            stringBuilder.append(node.val);
            stringBuilder.append("->");
            node = node.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

    public static String cycleLinked2String(ListNode2 node){
        int i=0;
        StringBuilder stringBuilder = new StringBuilder();
        while (node!=null && i<20){
            stringBuilder.append(node.val);
            stringBuilder.append("->");
            node = node.next;
            i++;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}
