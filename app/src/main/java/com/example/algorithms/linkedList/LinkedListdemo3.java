package com.example.algorithms.linkedList;

import com.example.algorithms.PrintUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转链表
 * 迭代或递归地反转链表
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class LinkedListdemo3 {

    private static int[] number = {1,2,3,4,5};
//    private static int[] number = {1};
    private static List<ListNode> head = new ArrayList<>();
    private static ListNode header;

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
        System.out.println(PrintUtils.linked2String(head.get(0)));
        System.out.println(PrintUtils.linked2String(reverseList3(head.get(0))));
    }

    public static ListNode reverseList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        if (head.next.next!=null){
            reverseList(head.next);
        }
        head.next.next = head;
        head.next = null;
        return head;
    }

    public static ListNode reverseList3(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextTmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTmp;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        //始终指向链表的头结点
        ListNode pFirst = head;
        //三个结点中的第一个结点
        ListNode pPre = pFirst;
        //当前需要反转的结点
        ListNode pCur = head.next;
        //下一次即将需要反转的结点
        ListNode pFuture = null;
        while (pCur!=null){
            pFuture = pCur.next;
            pPre.next = pFuture;
            pCur.next = pFirst;
            pFirst = pCur;
            pCur = pFuture;
        }
        return pFirst;
    }
}
