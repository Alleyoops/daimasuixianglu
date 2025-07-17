package com.leetcode.code;

import com.leetcode.util.ListNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class lc142Test {

    // 创建链表
    private ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    // 创建带环的链表
    private ListNode createCyclicLinkedList(int[] values, int cycleIndex) {
        if (values == null || values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleNode = null;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;

            if (i == cycleIndex) {
                cycleNode = current;
            }
        }

        if (cycleNode != null) {
            current.next = cycleNode; // 创建环
        }

        return head;
    }

    @Test
    public void testEmptyList() {
        // TC01: 空链表测试
        lc142 solution = new lc142();
        assertNull(solution.detectCycle(null));
    }

    @Test
    public void testNoCycle() {
        // TC02: 无环链表测试
        lc142 solution = new lc142();
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5});
        assertNull(solution.detectCycle(head));
    }

    @Test
    public void testSingleNodeWithoutCycle() {
        // TC03: 只有一个节点无环
        lc142 solution = new lc142();
        ListNode head = new ListNode(5);
        assertNull(solution.detectCycle(head));
    }

    @Test
    public void testSingleNodeWithCycle() {
        // TC04: 只有一个节点有环
        lc142 solution = new lc142();
        ListNode head = new ListNode(5);
        head.next = head; // 形成环

        ListNode result = solution.detectCycle(head);
        assertNotNull(result);
        assertEquals(5, result.val);
    }

    @Test
    public void testCycleAtLastNode() {
        // TC05: 环在最后一个节点
        lc142 solution = new lc142();
        ListNode head = createCyclicLinkedList(new int[]{1, 2, 3, 4}, 3); // 最后一个节点形成环
        ListNode result = solution.detectCycle(head);
        assertNotNull(result);
        assertEquals(4, result.val);
    }

    @Test
    public void testCycleAtMiddle() {
        // TC06: 环在中间某个节点
        lc142 solution = new lc142();
        ListNode head = createCyclicLinkedList(new int[]{3, 2, 0, -4, 5, 6}, 2); // 0节点形成环
        ListNode result = solution.detectCycle(head);
        assertNotNull(result);
        assertEquals(0, result.val);
    }

    @Test
    public void testComplexCycleStructure() {
        // TC07: 复杂环结构 - 多个节点形成环
        lc142 solution = new lc142();
        ListNode head = createCyclicLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 5); // 6节点形成环
        ListNode result = solution.detectCycle(head);
        assertNotNull(result);
        assertEquals(6, result.val);
    }
}
