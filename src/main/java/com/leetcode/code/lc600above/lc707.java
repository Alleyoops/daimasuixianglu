package com.leetcode.code.lc600above;

import com.leetcode.util.ListNode;

/*
LinkedList！LinkedList！LinkedList！

设计链表（注意是链表类LinkedList！！而不是节点类ListNode！！）

在链表类中实现这些功能：
get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
如果 index 等于链表的长度，则该节点将附加到链表的末尾。
如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */
public class lc707 {
    //成员变量：链表长度、虚拟头结点
    private int size;//节点计数（注意： size是大小 index是下标 index最大值为size-1）
    private final ListNode head;//虚拟头结点，不存储有效数据
    //无参构造器
    public lc707() {
        this.size = 0;
        this.head = new ListNode();
    }

    //get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        //首先排除非法index(虚拟头结点的index应该理解为-1)
        if (index<0||index>=size) return -1;
        ListNode current = head;
        //站在链表的角度来看，存储数据的节点是index==0开始，也就是虚拟头结点后面的一个节点的index为0
        //所以如果把虚拟头结点视为index=-1，查询第index的节点，应该是头结点后的第index+1个节点的val
        //实际节点：     head -> head.next -> head.next.next -> head.next.next.next
        //下标index：    -1  ->    0      ->       1        ->    2
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.val;
    }

    //addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。（等价于ddAtIndex(0, val);）
    public void addAtHead(int val) {
        //在虚拟头结点后面添加新节点
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    //addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。(等价于addAtIndex(size, val);//注意是size不是size-1，否则原链表最后一个节点会成为尾结点)
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode current = head;
        while (current.next!=null){
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    /*
    addAtIndex(index,val)：在链表中的第 index 个节点之前(注意：“节点之前”)添加值为 val  的节点。
    如果 index 等于链表的长度，则该节点将附加到链表的末尾。
    如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     */
    public void addAtIndex(int index, int val) {
        if (index<0) {
            addAtHead(val);
            size++;
        }
        else if (index<=size){
            ListNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }

    }

    //deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        if (index>=0 && index<size){
            ListNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

}
