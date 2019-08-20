package com.example.algorithms.recursive;

/**
 * output result:
 * start...index=0
 * start...index=1
 * start...index=2
 * start...index=3
 * start...index=4
 * index=4=e
 * index=3=d
 * index=2=c
 * index=1=b
 * index=0=a
 */
public class Recursive1 {
    public static void main(String[] args){
        char[] c = {'a', 'b', 'c', 'd', 'e'};
        printReverse(c);
    }

    private static void printReverse(char[] c){
        helper(0, c);
    }

    private static void helper(int index, char[] c){
        if (c==null || index>=c.length){
            return;
        }
        System.out.println("start..."+"index="+index);
        helper(index+1, c);
        System.out.println("index="+index+"="+c[index]);
    }
}
