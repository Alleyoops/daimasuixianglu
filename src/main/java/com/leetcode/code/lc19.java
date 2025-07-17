package com.leetcode.code;

import com.leetcode.util.ListNode;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
public class lc19 {
    //快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0,head);
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;//快指针先移动n次
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;//slow此时指向被删除节点的前一个节点
        }
        //删除操作
        if (slow.next == head) head = head.next;
        else slow.next = slow.next.next;
        return head;
    }
}
