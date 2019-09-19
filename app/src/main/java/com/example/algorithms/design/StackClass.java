package com.example.algorithms.design;

public class StackClass {

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(5);
        minStack.push(8);
        System.out.println("min=="+minStack.getMin());
        System.out.println("top=="+minStack.top());
        minStack.pop();
        System.out.println("top=="+minStack.top());
        minStack.pop();
        System.out.println("top=="+minStack.top());
        minStack.pop();
        System.out.println("top=="+minStack.top());
        minStack.pop();
        System.out.println("top=="+minStack.top());
    }
}
