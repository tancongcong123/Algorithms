package com.example.algorithms.linkedList;

import com.example.algorithms.PrintUtils;

/**
 * 判断链表中是否有环
 * 表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环
 *
 */
public class LinkedListDemo6 {

    private static int[] number = {1,2,7,9,1,5};
    private static int[] number2 = {1,2,3,4};

    private static ListNode2 getLinkedList(int[] numbers){
        int index = numbers.length-1;
        ListNode2 preNode = null;
        ListNode2 curNode = null;
        while (index>=0){
            curNode = new ListNode2(numbers[index]);
            curNode.next = preNode;
            preNode = curNode;
            index--;
        }
        return curNode;
    }

    private static ListNode2 getCycledLinkedList(int[] numbers){
        int index = 0;
        ListNode2 header = null;
        ListNode2 preNode = null;
        ListNode2 curNode = null;
        ListNode2 cycleNode = null;
        while (index<numbers.length){
            curNode = new ListNode2(numbers[index]);
            if (preNode!=null){
                preNode.next = curNode;
                if (header==null)
                    header = preNode;
            }
            preNode = curNode;
            if (index==3)
                cycleNode = curNode;
            index++;
        }
        preNode.next = cycleNode;
        return header;
    }

    public static void main(String[] args){
        ListNode2 header1 = getCycledLinkedList(number);
        ListNode2 header2 = getLinkedList(number2);
        System.out.println(PrintUtils.cycleLinked2String(header1));
        System.out.println(PrintUtils.cycleLinked2String(header2));
        System.out.println(hasCycle(header1));
        System.out.println(hasCycle(header2));
    }

    public static boolean hasCycle(ListNode2 head) {
        if (head==null || head.next==null)
            return false;
        ListNode2 slow = head;
        ListNode2 fast = head.next.next;
        while (slow!=null || fast!=null){
            if (slow==fast)
                return true;
            slow = slow.next;
            if (fast ==null || fast.next==null)
                return false;
            fast = fast.next.next;
        }
        return false;
    }
}
