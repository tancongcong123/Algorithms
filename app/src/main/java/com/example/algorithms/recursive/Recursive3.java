package com.example.algorithms.recursive;

import com.example.algorithms.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个函数，输出杨辉三角。
 *
 * output result:
 * result==[1]
 * result==[1,1]
 * result==[1,2,1]
 * result==[1,3,3,1]
 * result==[1,4,6,4,1]
 * result==[1,5,10,10,5,1]
 */
public class Recursive3 {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args){
        generate(6);
    }

    private static List<List<Integer>> generate(int numRows){
        if (numRows < 1){
            return new ArrayList<>();
        }
        for (int r = 0;r<=numRows; r++){
            List<Integer> item = new ArrayList<>();
            for (int i=0;i<r;i++){
                item.add(getItemNumber(i, r));
            }
            result.add(item);
            System.out.println("result=="+ PrintUtils.toString(item));
        }
        return result;
    }

    private static int getItemNumber(int index, int row){
        if (index==0 || index==row-1)
            return 1;
        return getItemNumber(index-1, row-1)+getItemNumber(index, row-1);
    }
}
