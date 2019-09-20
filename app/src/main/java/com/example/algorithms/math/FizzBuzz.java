package com.example.algorithms.math;

import com.example.algorithms.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 写一个程序，输出从 1 到 n 数字的字符串表示
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3. 如果 n 同时是3和5的倍数，输出 “FizzBuzz”
 */
public class FizzBuzz {

    public static void main(String[] args){
        System.out.println(PrintUtils.toString(fizzBuzz(16)));
    }

    public static List<String> fizzBuzz(int n) {
        int i=1;
        List<String> result = new ArrayList<>();
        while (i<=n){
            if (i%3==0 && i%5==0){
                result.add("FizzBuzz");
            }else if (i%3==0){
                result.add("Fizz");
            }else if (i%5==0){
                result.add("Buzz");
            }else {
                result.add(""+i);
            }
            i++;
        }
        return result;
    }

}
