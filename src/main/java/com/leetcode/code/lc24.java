package com.leetcode.code;

import com.leetcode.util.ListNode;

import java.util.HashMap;

//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
//你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
public class lc24 {
    //直接法
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(0,head);//建议使用虚拟头结点，这样会方便很多，要不然每次针对头结点（没有前一个指针指向头结点），还要单独处理。
        ListNode current = dummyNode;//当前节点为虚拟头结点
        ListNode temp1,temp2;
        while (current.next !=null && current.next.next!=null){
            temp1 = current.next;
            temp2 = current.next.next.next;
            current.next = temp1.next;//步骤一
            current.next.next = temp1;//步骤二
            temp1.next = temp2;//步骤三
            current = temp1;
            //如果将步骤 2,3 交换顺序，这样不用定义 temp 节点
        }
        return dummyNode.next;
    }
    //递归法
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = swapPairs2(head.next.next);
        temp.next = head;
        return temp;
    }
}
