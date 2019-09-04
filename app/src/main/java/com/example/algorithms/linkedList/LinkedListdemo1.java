package com.example.algorithms.linkedList;

import com.example.algorithms.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点
 *
 * input: head = [4,5,1,9], node = 5
 * output: [4,1,9]
 */
public class LinkedListdemo1 {

    private static int[] number = {4,5,1,9};
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
        ListNode delNode = new ListNode(9);
        deleteNode(delNode);
    }

    public static void deleteNode(ListNode node) {
        int index = head.indexOf(node);
        System.out.println("index::"+index);
        if(index==head.size()-1){
            head.get(index-1).next = null;
        }else if (index>0){
            head.get(index-1).next = head.get(index+1);
        }
        head.remove(node);
        System.out.println(PrintUtils.toListString(head));
    }

    public static void deleteNode2(ListNode node) {
        if (node.next==null){
            System.out.println(PrintUtils.toListString(head));
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
        System.out.println(PrintUtils.toListString(head));
    }
}
