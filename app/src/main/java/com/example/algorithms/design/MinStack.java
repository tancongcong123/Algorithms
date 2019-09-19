package com.example.algorithms.design;

import com.example.algorithms.PrintUtils;

import java.util.ArrayList;

public class MinStack {

    private ArrayList<Integer> arrayList;

    public MinStack() {
        arrayList = new ArrayList<>();
    }

    public void push(int x) {
        arrayList.add(x);
        System.out.println(PrintUtils.toString(arrayList));
    }

    public void pop(){
        if (arrayList.size()>0){
            arrayList.remove(arrayList.size()-1);
            System.out.println(PrintUtils.toString(arrayList));
        }else {
            throw new RuntimeException("this is an empty stack");
        }
    }

    public int top() {
        if (arrayList.size()>0){
            return arrayList.get(arrayList.size()-1);
        }else {
            throw new RuntimeException("this is an empty stack");
        }
    }

    public int getMin() {
        if (arrayList.size()>0){
            int min = Integer.MAX_VALUE;
            for (int i:arrayList){
                min=Math.min(i, min);
            }
            return min;
        }else {
            throw new RuntimeException("this is an empty stack");
        }
    }
}
