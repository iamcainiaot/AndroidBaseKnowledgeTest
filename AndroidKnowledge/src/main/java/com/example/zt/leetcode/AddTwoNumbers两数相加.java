package com.example.zt.leetcode;

public class AddTwoNumbers两数相加 {
    /*
        给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
        并且它们的每个节点只能存储 一位 数字。
        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        示例：
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        addTwoNumbers(l1, l2);
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建一个新的链表
        ListNode LastListNode = new ListNode(0);
        ListNode p = l1, q = l2;
        // 赋值给新链表
        ListNode newListNode = LastListNode;
        int carry = 0;
        while (p != null || q != null) {
            // 如果链表为空，则赋值为空，否则为链表中该节点的值
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            // 节点值相加之和
            int sum = carry + x + y;
            // 计算进位  / 求模 ,% 取余  ; 17 / 5 = 3 ; 17 % 5 = 2
            carry = sum / 10;
            // 链表赋值
            newListNode.next = new ListNode(sum % 10);
            // 指针指向最后的一个节点
            newListNode = newListNode.next;
            // 指针右移
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            newListNode.next = new ListNode(carry);
        }
        return LastListNode.next;
    }
}
