package com.example.algorithms.linkedList;

import com.example.algorithms.PrintUtils;

import java.util.Arrays;

/**
 * 判断一个链表是否为回文链表
 *
 * 输入：1->2->2->1
 * 输出：true
 *
 * 用 O(n) 时间复杂度和 O(1) 空间复杂度解决
 */
public class LinkedListDemo5 {

    private static int[] number = {1,2,3,3,2,1};
    private static int[] number1 = {1,3,4,6,8};

    private static ListNode getLinkedList(int[] numbers){
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
        System.out.println("---------------------");
        System.out.println(isPalindrome2(header1));
        System.out.println(isPalindrome(header2));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null)
            return true;
        ListNode copyNode = copy(head);
        ListNode reverseNode = reverseList3(head);
        while (copyNode!=null || reverseNode!=null){
            if (copyNode.val!=reverseNode.val)
                return false;
            copyNode = copyNode.next;
            reverseNode = reverseNode.next;
        }
        return true;
    }

    public static ListNode copy(ListNode head) {
        ListNode header = new ListNode(head.val);
        ListNode pre = header;
        ListNode curr;
        head = head.next;
        while(head != null){
            curr = new ListNode(head.val);
            pre.next = curr;
            pre = curr;
            head = head.next;
        }
        return header;
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

    /**
     * 快慢指针
     * 前一半反转与后一半对比
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        ListNode pre = null;
        while (fast!=null && fast.next != null){
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
            fast = fast.next.next;
        }

        if (fast == null){ //等于null 是偶数    不等于null 是偶数
            slow = slow.next;
        }else{
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        while (pre != null){
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
