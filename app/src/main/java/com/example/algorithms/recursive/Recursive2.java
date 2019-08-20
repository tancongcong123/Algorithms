package com.example.algorithms.recursive;

import com.example.algorithms.PrintUtils;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * output result:
 * old c=[a,b,c,d,e]
 * new c=[e,d,c,b,a]
 */
public class Recursive2 {
    public static void main(String[] args){
        char[] c = {'a', 'b', 'c', 'd', 'e'};
        System.out.println("old c="+ PrintUtils.toString(c));
        reverse(c);
    }

    private static void reverse(char[] c){
        helper(0, c.length-1, c);
        System.out.println("new c="+PrintUtils.toString(c));
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
}
