package com.leetcode.code;
import com.leetcode.code.lc1_200.lc24;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.leetcode.util.ListNode;

public class lc24Test {


    // 被测类实例
    private final lc24 solution = new lc24();

    /**
     * 辅助方法：创建链表
     * @param values 链表中的值数组
     * @return 链表头节点
     */
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

    /**
     * 辅助方法：检查链表是否包含预期值序列
     * @param expectedValues 预期的值数组
     * @param actualHead 实际的链表头
     */
    private void assertLinkedListEquals(int[] expectedValues, ListNode actualHead) {
        ListNode current = actualHead;
        int index = 0;

        while (index < expectedValues.length && current != null) {
            assertEquals(expectedValues[index], current.val);
            index++;
            current = current.next;
        }

        // 确保两者同时到达末尾
        assertTrue(index == expectedValues.length && current == null);
    }
    /**
     * 测试空链表的情况
     * 预期结果：返回null
     */
    @Test
    public void testEmptyList() {
        assertNull(solution.swapPairs1(null));
    }

    /**
     * 测试只有一个节点的链表
     * 预期结果：返回原链表
     */
    @Test
    public void testSingleNode() {
        ListNode head = new ListNode(1);
        ListNode result = solution.swapPairs1(head);
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNull(result.next);
    }

    /**
     * 测试两个节点的交换
     * 输入: 1 -> 2
     * 预期结果: 2 -> 1
     */
    @Test
    public void testTwoNodes() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode result = solution.swapPairs1(head);

        assertNotNull(result);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertNull(result.next.next);
    }

    /**
     * 测试三个节点的情况
     * 输入: 1 -> 2 -> 3
     * 预期结果: 2 -> 1 -> 3
     */
    @Test
    public void testThreeNodes() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode result = solution.swapPairs1(head);

        assertNotNull(result);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertEquals(3, result.next.next.val);
        assertNull(result.next.next.next);
    }

    /**
     * 测试四个节点的情况
     * 输入: 1 -> 2 -> 3 -> 4
     * 预期结果: 2 -> 1 -> 4 -> 3
     */
    @Test
    public void testFourNodes() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode result = solution.swapPairs1(head);

        assertNotNull(result);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertEquals(4, result.next.next.val);
        assertEquals(3, result.next.next.next.val);
        assertNull(result.next.next.next.next);
    }





    /**
     * 使用辅助方法测试五个节点的情况
     * 输入: 1 -> 2 -> 3 -> 4 -> 5
     * 预期结果: 2 -> 1 -> 4 -> 3 -> 5
     */
    @Test
    public void testFiveNodes() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {2, 1, 4, 3, 5};

        ListNode head = createLinkedList(input);
        ListNode result = solution.swapPairs1(head);

        assertLinkedListEquals(expected, result);
    }

    /**
     * 测试空链表的情况
     * 预期结果：返回null
     */
    @Test
    public void testEmptyList2() {
        assertNull(solution.swapPairs2(null));
    }

    /**
     * 测试只有一个节点的链表
     * 预期结果：返回原链表
     */
    @Test
    public void testSingleNode2() {
        ListNode head = new ListNode(1);
        ListNode result = solution.swapPairs2(head);
        assertNotNull(result);
        assertEquals(1, result.val);
        assertNull(result.next);
    }

    /**
     * 测试两个节点的交换
     * 输入: 1 -> 2
     * 预期结果: 2 -> 1
     */
    @Test
    public void testTwoNodes2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode result = solution.swapPairs2(head);

        assertNotNull(result);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertNull(result.next.next);
    }

    /**
     * 测试三个节点的情况
     * 输入: 1 -> 2 -> 3
     * 预期结果: 2 -> 1 -> 3
     */
    @Test
    public void testThreeNodes2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode result = solution.swapPairs2(head);

        assertNotNull(result);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertEquals(3, result.next.next.val);
        assertNull(result.next.next.next);
    }

    /**
     * 测试四个节点的情况
     * 输入: 1 -> 2 -> 3 -> 4
     * 预期结果: 2 -> 1 -> 4 -> 3
     */
    @Test
    public void testFourNodes2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode result = solution.swapPairs2(head);

        assertNotNull(result);
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertEquals(4, result.next.next.val);
        assertEquals(3, result.next.next.next.val);
        assertNull(result.next.next.next.next);
    }





    /**
     * 使用辅助方法测试五个节点的情况
     * 输入: 1 -> 2 -> 3 -> 4 -> 5
     * 预期结果: 2 -> 1 -> 4 -> 3 -> 5
     */
    @Test
    public void testFiveNodes2() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {2, 1, 4, 3, 5};

        ListNode head = createLinkedList(input);
        ListNode result = solution.swapPairs2(head);

        assertLinkedListEquals(expected, result);
    }
}
