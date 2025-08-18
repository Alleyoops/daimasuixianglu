package com.leetcode.code.lc200_400;

import com.leetcode.util.ListNode;

/*
 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class lc203 {
    //方法一：直接使用原来的链表来进行头结点的删除操作。
    public ListNode removeElements1(ListNode head, int val) {
        //删除头结点
        while (head!=null && head.val == val){//头结点存在且头结点为val时
            head = head.next;//头结点向后移动一位
        }
        //删除中间节点
        ListNode current = head;
        while (current!=null && current.next!=null){//删除可能等于val的头结点后，若当前的头结点和下个节点存在
            if (current.next.val == val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }

    //方法二，设置一个虚拟头结点来删除等于val的头结点
    public ListNode removeElements2(ListNode head, int val) {
        //定义一个指向真实头结点的虚拟头结点
        ListNode dummyNode = new ListNode(0,head);
        //定义当前节点
        ListNode current = dummyNode;
        while (current.next!=null){
            if(current.next.val == val){
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }
        return dummyNode.next;
    }

    /*
    也可以通过递归的思路解决本题:
    基础情况：对于空链表，不需要移除元素。
    递归情况：首先检查头节点的值是否为 val，如果是则移除头节点，答案即为在头节点的后续节点上递归的结果；
    如果头节点的值不为 val，则答案为头节点与在头节点的后续节点上递归得到的新链表拼接的结果。
     */
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        // 假设 removeElements() 返回后面完整的已经去掉val节点的子链表
        // 在当前递归层用当前节点接住后面的子链表
        // 随后判断当前层的node是否需要被删除，如果是，就返回
        // 也可以先判断是否需要删除当前node，但是这样条件语句会比较不好想
        head.next = removeElements3(head.next, val);
        if (head.val == val) {
            return head.next;
        }
        return head;

        // 实际上就是还原一个从尾部开始重新构建链表的过程
    }
}
