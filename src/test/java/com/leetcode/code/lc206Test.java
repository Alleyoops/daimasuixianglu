package com.leetcode.code;

import com.leetcode.util.ListNode;
import com.leetcode.code.lc206;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * lc206.reverseList(ListNode head) 的单元测试类
 */
public class lc206Test {

    /**
     * 工具方法：构建链表
     * @param values 节点值数组
     * @return 链表头节点
     */
    private ListNode buildList(int[] values) {
        if (values == null || values.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * 工具方法：将链表转为字符串表示
     * @param head 链表头节点
     * @return 字符串表示
     */
    private String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        return sb.toString();
    }

    /**
     * TC01: 空链表测试
     */
    @Test
    public void testReverseList_EmptyList() {
        lc206 solution = new lc206();
        ListNode result = solution.reverseList1(null);
        assertNull("空链表应返回 null", result);
    }

    /**
     * TC02: 单节点链表测试
     */
    @Test
    public void testReverseList_SingleNode() {
        lc206 solution = new lc206();
        ListNode input = new ListNode(1);
        ListNode result = solution.reverseList1(input);

        assertNotNull("结果不应为空", result);
        assertEquals("单节点链表反转后仍为 [1]", 1, result.val);
        assertNull("单节点链表反转后 next 应为 null", result.next);
    }

    /**
     * TC03: 多节点链表测试
     */
    @Test
    public void testReverseList_MultipleNodes() {
        lc206 solution = new lc206();

        // 构建原始链表: 1 -> 2 -> 3 -> 4
        int[] inputValues = {1, 2, 3, 4};
        ListNode input = buildList(inputValues);

        // 反转链表
        ListNode result = solution.reverseList1(input);

        // 验证反转后的链表是否为 4 -> 3 -> 2 -> 1
        int[] expectedValues = {4, 3, 2, 1};
        ListNode expected = buildList(expectedValues);

        // 遍历比较
        ListNode p = result;
        ListNode q = expected;
        while (p != null && q != null) {
            assertEquals("节点值不匹配", q.val, p.val);
            p = p.next;
            q = q.next;
        }

        assertNull("实际链表比预期长", p);
        assertNull("预期链表比实际长", q);
    }

    /**
     * TC01: 空链表测试
     */
    @Test
    public void testReverseList2_EmptyList() {
        lc206 solution = new lc206();
        ListNode result = solution.reverseList2(null);
        assertNull("空链表应返回 null", result);
    }

    /**
     * TC02: 单节点链表测试
     */
    @Test
    public void testReverseList2_SingleNode() {
        lc206 solution = new lc206();
        ListNode input = new ListNode(1);
        ListNode result = solution.reverseList2(input);

        assertNotNull("结果不应为空", result);
        assertEquals("单节点链表反转后仍为 [1]", 1, result.val);
        assertNull("单节点链表反转后 next 应为 null", result.next);
    }

    /**
     * TC03: 多节点链表测试
     */
    @Test
    public void testReverseList2_MultipleNodes() {
        lc206 solution = new lc206();

        // 构建原始链表: 1 -> 2 -> 3 -> 4
        int[] inputValues = {1, 2, 3, 4};
        ListNode input = buildList(inputValues);

        // 反转链表
        ListNode result = solution.reverseList2(input);

        // 验证反转后的链表是否为 4 -> 3 -> 2 -> 1
        int[] expectedValues = {4, 3, 2, 1};
        ListNode expected = buildList(expectedValues);

        // 遍历比较
        ListNode p = result;
        ListNode q = expected;
        while (p != null && q != null) {
            assertEquals("节点值不匹配", q.val, p.val);
            p = p.next;
            q = q.next;
        }

        assertNull("实际链表比预期长", p);
        assertNull("预期链表比实际长", q);
    }
}
