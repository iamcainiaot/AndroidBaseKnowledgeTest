package com.example.zt.leetcode;

public class 旋转链表 {
    public static void main(String[] args) {

    }

    private ListNode rotateRightList(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode tempNode = head;
        // 遍历链表得出总长度
        while (tempNode  != null) {
            tempNode = tempNode.next;
            length++;
        }
        // 求模
        k = k % length;

        ListNode returnNode = null;
        // 定义旋转前的头节点和旋转后的头节点
        ListNode beforeNode = head;
        ListNode afterNode = head;

        for (int i = 0;i < k;i++) {
            beforeNode = beforeNode.next;
        }

        // 一直往后遍历
        while (beforeNode.next != null) {
            beforeNode = beforeNode.next;
            afterNode = afterNode.next;
        }
        //beforeNode指向之前的第一个节点，将最后一个节点指向之前的第一个节点
        beforeNode.next = head;
        // 遍历完后，afterNode节点的next就是新的头节点
        returnNode = afterNode.next;
        // 防止成环
        afterNode.next = null;
        return returnNode;
    }

}
