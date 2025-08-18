package com.leetcode.code.lc1_200;

import com.leetcode.util.ListNode;

//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
public class lc160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //排除极端可能性
        if (headA == null || headB == null) return null;
        //先求出两个链表的长度
        int sizeA = 0;
        int sizeB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            curA = curA.next;
            sizeA++;
        }
        while (curB != null) {
            curB = curB.next;
            sizeB++;
        }
        //同步两个链表的当前指针
        int n;
        curA = headA;//当前指针重新指向头结点
        curB = headB;
        if (sizeA >= sizeB) {
            n = sizeA - sizeB;
            for (int i = 0; i < n; i++) {
                curA = curA.next;
            }
        } else {
            n = sizeB - sizeA;
            for (int i = 0; i < n; i++) {
                curB = curB.next;
            }
        }
        //寻找相交节点
        //如果在头结点相交
        if (curA == curB) return curA;
        while (curA.next != null) {
            curA = curA.next;
            curB = curB.next;
            if (curA == curB) return curA;
        }
        return null;
    }

    //(版本二) 合并链表实现同步移动
    public class Solution {
        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            // p1 指向 A 链表头结点，p2 指向 B 链表头结点
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                // p1 走一步，如果走到 A 链表末尾，转到 B 链表
                if (p1 == null) p1 = headB;
                else p1 = p1.next;
                // p2 走一步，如果走到 B 链表末尾，转到 A 链表
                if (p2 == null) p2 = headA;
                else p2 = p2.next;
            }
            return p1;
        }
    }
    /*
    🧠 举个生活中的例子：两个人走路找汇合点
    想象你和你的朋友要从不同的起点出发，去同一个咖啡馆碰面。你们都不知道对方走多远，也不知道咖啡馆在哪里。
    💡 规则：
    你先走完自己的路，然后接着走你朋友的路。
    你朋友也一样，先走完自己的路，再走你的路。
    你们始终保持相同的速度（每步一格）。
    ✅ 结论：
    如果你们的路线有交点，你们最终会在那个交点相遇。
    如果没有交点，你们会同时走到终点（都为 null）。
     */
}
