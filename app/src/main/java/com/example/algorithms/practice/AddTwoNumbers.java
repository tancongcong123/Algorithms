package com.example.algorithms.practice;

import com.example.algorithms.linkedList.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字
 */
public class AddTwoNumbers {

    public static void main(String[] args){
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null)
            return null;
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        int remainder = 0;
        ListNode head = null;
        ListNode preNode = null;
        ListNode currentNode = null;
        int currentVal = 0;
        while (l1!=null || l2!=null){
            if (l1==null){
                currentVal = l2.val+remainder;
                l2 = l2.next;
            }else if (l2==null){
                currentVal = l1.val+remainder;
                l1 = l1.next;
            }else {
                currentVal = l1.val+l2.val+remainder;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (currentVal>9){
                remainder = 1;
                currentVal = currentVal-10;
            }else {
                remainder = 0;
            }
            currentNode = new ListNode(currentVal);
            if (head==null){
                head = currentNode;
            }
            if (preNode!=null){
                preNode.next = currentNode;
            }
            preNode = currentNode;
        }
        if (remainder==1){
            currentNode = new ListNode(1);
            preNode.next = currentNode;
        }
        return head;
    }
}
