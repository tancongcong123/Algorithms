package com.example.algorithms.other;

import com.example.algorithms.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class Generate {

    public static void main(String[] args){
        System.out.println(PrintUtils.toString(generate(30)));
    }

    public static List<List<Integer>> generate(int numRows) {
        if (numRows < 1){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        result.add(row1);
        for (int r = 2;r<=numRows; r++){
            List<Integer> item = new ArrayList<>();
            for (int i=0;i<r;i++){
                if (i==0 || i==r-1){
                    item.add(1);
                }else {
                    item.add(result.get(r-2).get(i-1)+result.get(r-2).get(i));
                }
            }
            result.add(item);
        }
        return result;
    }
}
