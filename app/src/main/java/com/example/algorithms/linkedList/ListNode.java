package com.example.algorithms.linkedList;

import androidx.annotation.Nullable;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode getNext() {
        return next;
    }

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (((ListNode) obj).val==val)
            return true;
        return false;
    }
}
