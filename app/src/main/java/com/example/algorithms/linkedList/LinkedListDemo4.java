package com.example.algorithms.linkedList;

import com.example.algorithms.PrintUtils;

import java.util.Arrays;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class LinkedListDemo4 {

    private static int[] number = {1,2,4,4};
    private static int[] number1 = {1,3,4,6,8};

    private static ListNode getLinkedList(int[] numbers){
        Arrays.sort(numbers);
        int index = numbers.length-1;
        ListNode preNode = null;
        ListNode curNode = null;
        while (index>=0){
            curNode = new ListNode(numbers[index]);
            curNode.next = preNode;
            preNode = curNode;
            index--;
        }
        return curNode;
    }

    public static void main(String[] args){
        ListNode header1 = getLinkedList(number);
        ListNode header2 = getLinkedList(number1);
        System.out.println(PrintUtils.linked2String(header1));
        System.out.println(PrintUtils.linked2String(header2));
        System.out.println(PrintUtils.linked2String(mergeTwoLists(header1, header2)));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;
        ListNode header = null;
        ListNode preNode = null;
        ListNode curNode;
        while (!(l1==null && l2==null)){
            if (l1==null && l2!=null){
                curNode = new ListNode(l2.val);
                l2 = l2.next;
            }else if (l2==null && l1!=null){
                curNode = new ListNode(l1.val);
                l1 = l1.next;
            }else if (l1.val<=l2.val){
                curNode = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                curNode = new ListNode(l2.val);
                l2 = l2.next;
            }
            if (preNode!=null){
                preNode.next = curNode;
                if (header==null)
                    header = preNode;
            }
            preNode = curNode;
        }

        return header;
    }
}
