package com.example.algorithms.recursive;

import com.example.algorithms.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个函数，输出杨辉三角的某一行。
 *
 * output result:
 * result==[1,5,10,10,5,1]
 */
public class Recursive4 {

    public static void main(String[] args){
        generate(6);
    }

    private static List<Integer> generate(int numRows){
        if (numRows < 1){
            return new ArrayList<>();
        }
        List<Integer> item = new ArrayList<>();
        for (int i=0;i<numRows;i++){
            item.add(getItemNumber(i, numRows));
        }
        System.out.println("item = "+ PrintUtils.toString(item));
        return item;
    }

    private static int getItemNumber(int index, int row){
        if (index==0 || index==row-1)
            return 1;
        return getItemNumber(index-1, row-1)+getItemNumber(index, row-1);
    }
}
