package com.leetcode.code.lc200_400;

import com.leetcode.util.ListNode;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
public class lc206 {
    //双指针法(但还需要第三个temp指针来提前保留cur的下一个节点)
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;// 保存下一个节点
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    //递归法
    public ListNode reverseList2(ListNode head) {
        if (head == null ) return null;

        ListNode newHead = reverseList2(head.next);
        if (newHead == null) return head;

        ListNode cur = newHead;
//        while (cur.next!=null){
//            cur = cur.next;
//        }
//        cur.next = head;
        //上面三行应该优化成
        head.next.next = head;

        head.next = null;
        return newHead;
    }

}
