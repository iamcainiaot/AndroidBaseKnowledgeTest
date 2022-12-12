package com.example.zt.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 获取倒数第k个节点 {
    public static void main(String[] args) {


    }

    int count = 0;
    private ListNode mNode;

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }
        head.next = removeNthFromEnd(head.next, n);
        count++;
        if (count == n) {
            mNode = head.next;
            return head.next;
        }
        return head;

    }


}
