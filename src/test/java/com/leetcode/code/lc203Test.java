package com.leetcode.code;

import com.leetcode.code.lc200_400.lc203;
import com.leetcode.util.ListNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class lc203Test {
    private lc203 solution;
    @Before
    public void setUp() throws Exception {
        solution = new lc203();
    }

    @Test
    public void testRemoveElements1_EmptyList() {
        ListNode result = solution.removeElements1(null, 5);
        assertNull(result);
    }

    /**
     * TC02: 删除唯一节点
     */
    @Test
    public void testRemoveElements1_SingleNodeMatched() {
        ListNode head = new ListNode(1);
        ListNode result = solution.removeElements1(head, 1);
        assertNull(result);
    }

    /**
     * TC03: 唯一节点不匹配
     */
    @Test
    public void testRemoveElements1_SingleNodeNotMatched() {
        ListNode head = new ListNode(1);
        ListNode result = solution.removeElements1(head, 2);
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNull(result.next);
    }

    /**
     * TC04: 多个连续头结点匹配
     */
    @Test
    public void testRemoveElements1_HeadNodesMatched() {
        // 构造链表: 1 -> 1 -> 1 -> null
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1)));
        ListNode result = solution.removeElements1(head, 1);
        assertNull(result);
    }

    /**
     * TC05: 中间节点匹配
     */
    @Test
    public void testRemoveElements1_MiddleNodesMatched() {
        // 构造链表: 1 -> 2 -> 3 -> 2 -> 1 -> null
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(1)))));
        ListNode result = solution.removeElements1(head, 2);

        // 预期结果: 1 -> 3 -> 1 -> null
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNotNull(result.next);
        assertEquals(3, result.next.val);
        assertNotNull(result.next.next);
        assertEquals(1, result.next.next.val);
        assertNull(result.next.next.next);
    }

    /**
     * TC06: 混合头尾和中间节点匹配
     */
    @Test
    public void testRemoveElements1_MixedNodesMatched() {
        // 构造链表: 2 -> 2 -> 1 -> 2 -> 3 -> 2 -> null
        ListNode head = new ListNode(2,
                new ListNode(2,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(2))))));
        ListNode result = solution.removeElements1(head, 2);

        // 预期结果: 1 -> 3 -> null
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNotNull(result.next);
        assertEquals(3, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    public void testRemoveElements2_EmptyList() {
        ListNode result = solution.removeElements1(null, 5);
        assertNull(result);
    }

    /**
     * TC02: 删除唯一节点
     */
    @Test
    public void testRemoveElements2_SingleNodeMatched() {
        ListNode head = new ListNode(1);
        ListNode result = solution.removeElements1(head, 1);
        assertNull(result);
    }

    /**
     * TC03: 唯一节点不匹配
     */
    @Test
    public void testRemoveElements2_SingleNodeNotMatched() {
        ListNode head = new ListNode(1);
        ListNode result = solution.removeElements1(head, 2);
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNull(result.next);
    }

    /**
     * TC04: 多个连续头结点匹配
     */
    @Test
    public void testRemoveElements2_HeadNodesMatched() {
        // 构造链表: 1 -> 1 -> 1 -> null
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1)));
        ListNode result = solution.removeElements1(head, 1);
        assertNull(result);
    }

    /**
     * TC05: 中间节点匹配
     */
    @Test
    public void testRemoveElements2_MiddleNodesMatched() {
        // 构造链表: 1 -> 2 -> 3 -> 2 -> 1 -> null
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(1)))));
        ListNode result = solution.removeElements1(head, 2);

        // 预期结果: 1 -> 3 -> 1 -> null
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNotNull(result.next);
        assertEquals(3, result.next.val);
        assertNotNull(result.next.next);
        assertEquals(1, result.next.next.val);
        assertNull(result.next.next.next);
    }

    /**
     * TC06: 混合头尾和中间节点匹配
     */
    @Test
    public void testRemoveElements2_MixedNodesMatched() {
        // 构造链表: 2 -> 2 -> 1 -> 2 -> 3 -> 2 -> null
        ListNode head = new ListNode(2,
                new ListNode(2,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(2))))));
        ListNode result = solution.removeElements1(head, 2);

        // 预期结果: 1 -> 3 -> null
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNotNull(result.next);
        assertEquals(3, result.next.val);
        assertNull(result.next.next);
    }

    public void testRemoveElements3_EmptyList() {
        ListNode result = solution.removeElements1(null, 5);
        assertNull(result);
    }

    /**
     * TC02: 删除唯一节点
     */
    @Test
    public void testRemoveElements3_SingleNodeMatched() {
        ListNode head = new ListNode(1);
        ListNode result = solution.removeElements1(head, 1);
        assertNull(result);
    }

    /**
     * TC03: 唯一节点不匹配
     */
    @Test
    public void testRemoveElements3_SingleNodeNotMatched() {
        ListNode head = new ListNode(1);
        ListNode result = solution.removeElements1(head, 2);
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNull(result.next);
    }

    /**
     * TC04: 多个连续头结点匹配
     */
    @Test
    public void testRemoveElements3_HeadNodesMatched() {
        // 构造链表: 1 -> 1 -> 1 -> null
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(1)));
        ListNode result = solution.removeElements1(head, 1);
        assertNull(result);
    }

    /**
     * TC05: 中间节点匹配
     */
    @Test
    public void testRemoveElements3_MiddleNodesMatched() {
        // 构造链表: 1 -> 2 -> 3 -> 2 -> 1 -> null
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(1)))));
        ListNode result = solution.removeElements1(head, 2);

        // 预期结果: 1 -> 3 -> 1 -> null
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNotNull(result.next);
        assertEquals(3, result.next.val);
        assertNotNull(result.next.next);
        assertEquals(1, result.next.next.val);
        assertNull(result.next.next.next);
    }

    /**
     * TC06: 混合头尾和中间节点匹配
     */
    @Test
    public void testRemoveElements3_MixedNodesMatched() {
        // 构造链表: 2 -> 2 -> 1 -> 2 -> 3 -> 2 -> null
        ListNode head = new ListNode(2,
                new ListNode(2,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(3,
                                                new ListNode(2))))));
        ListNode result = solution.removeElements1(head, 2);

        // 预期结果: 1 -> 3 -> null
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNotNull(result.next);
        assertEquals(3, result.next.val);
        assertNull(result.next.next);
    }
}