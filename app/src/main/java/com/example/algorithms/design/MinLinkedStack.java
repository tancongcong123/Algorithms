package com.example.algorithms.design;

public class MinLinkedStack {
    private class Node {
        int val;    // 结点的值
        Node next;  // 指向下一结点
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;   // 定义链表头结点
    private int min;    // 当前最小值，初始化为Integer最大值

    public MinLinkedStack() {
        head = null;
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x <= min) {
            head = new Node(min, head);
            min = x;
        }
        head = new Node(x, head);
    }

    public void pop() {
        if(head.val == min) {
            min = head.next.val;
            head = head.next.next;
        } else {
            head = head.next;
        }
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return min;
    }
}
