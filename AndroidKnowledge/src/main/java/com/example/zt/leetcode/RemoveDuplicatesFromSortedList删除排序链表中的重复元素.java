package com.example.zt.leetcode;

public class RemoveDuplicatesFromSortedList删除排序链表中的重复元素 {
    /*
    给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    示例 1:
    输入: 1->1->2
    输出: 1->2
    示例 2:
    输入: 1->1->2->3->3
    输出: 1->2->3
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        deleteDuplicates(listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;

    }
}
