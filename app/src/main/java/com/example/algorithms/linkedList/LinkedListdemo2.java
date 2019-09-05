package com.example.algorithms.linkedList;

import com.example.algorithms.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
 *
 * input: 1->2->3->4->5, n = 2
 * output: 1->2->3->5
 */
public class LinkedListdemo2 {

//    private static int[] number = {1,2,3,4,5};
    private static int[] number = {1};
    private static List<ListNode> head = new ArrayList<>();

    public static void main(String[] args){
        ListNode preNode = new ListNode(number[0]);
        ListNode node;
        for (int i=0;i<number.length;i++){
            node = new ListNode(number[i]);
            head.add(node);
            if (i==0){
                preNode = node;
            }else {
                preNode.next = node;
                preNode = node;
            }
        }
        System.out.println(PrintUtils.toListString(head));
        removeNthFromEnd(head.get(0), 1);
        System.out.println(PrintUtils.toListString(head));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode f = head;
        ListNode s = head;
        for (int i = 0; i < n; i++) {
            f = f.next;
        }
        if(f == null) {
            return head = head.next;
        }
        while(f.next!=null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;

        return head;
    }
}
