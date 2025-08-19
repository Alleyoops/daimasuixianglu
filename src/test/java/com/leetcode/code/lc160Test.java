package com.leetcode.code;

import com.leetcode.util.ListNode;
import com.leetcode.code.lc100_200.lc160;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * lc160单元测试类 - 测试获取两个链表的交点功能
 */
public class lc160Test {

    /**
     * 测试用例TC001：两个链表在中间节点相交
     * 预期结果：返回相交节点
     */
    @Test
    public void testGetIntersectionNode_MiddleIntersection() {
        // 构建公共部分
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));

        // 构建链表A: 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = new ListNode(4, new ListNode(1, common));

        // 构建链表B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, common)));

        // 创建被测对象并执行测试
        lc160 solution = new lc160();
        ListNode result = solution.getIntersectionNode(headA, headB);

        // 验证结果
        assertNotNull(result);
        assertEquals(8, result.val);
    }

    /**
     * 测试用例TC002：两个链表不相交
     * 预期结果：返回null
     */
    @Test
    public void testGetIntersectionNode_NoIntersection() {
        // 构建链表A: 1 -> 2 -> 3
        ListNode headA = new ListNode(1, new ListNode(2, new ListNode(3)));

        // 构建链表B: 4 -> 5 -> 6
        ListNode headB = new ListNode(4, new ListNode(5, new ListNode(6)));

        // 创建被测对象并执行测试
        lc160 solution = new lc160();
        ListNode result = solution.getIntersectionNode(headA, headB);

        // 验证结果
        assertNull(result);
    }

    /**
     * 测试用例TC003：两个链表在头节点相交
     * 预期结果：返回头节点
     */
    @Test
    public void testGetIntersectionNode_HeadIntersection() {
        // 构建公共链表
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

        // 创建被测对象并执行测试
        lc160 solution = new lc160();
        ListNode result = solution.getIntersectionNode(head, head);

        // 验证结果
        assertNotNull(result);
        assertEquals(1, result.val);
    }

    /**
     * 测试用例TC004：链表A为空
     * 预期结果：返回null
     */
    @Test
    public void testGetIntersectionNode_HeadAIsNull() {
        // 构建链表B: 4 -> 5 -> 6
        ListNode headB = new ListNode(4, new ListNode(5, new ListNode(6)));

        // 创建被测对象并执行测试
        lc160 solution = new lc160();
        ListNode result = solution.getIntersectionNode(null, headB);

        // 验证结果
        assertNull(result);
    }

    /**
     * 测试用例TC005：链表B为空
     * 预期结果：返回null
     */
    @Test
    public void testGetIntersectionNode_HeadBIsNull() {
        // 构建链表A: 1 -> 2 -> 3
        ListNode headA = new ListNode(1, new ListNode(2, new ListNode(3)));

        // 创建被测对象并执行测试
        lc160 solution = new lc160();
        ListNode result = solution.getIntersectionNode(headA, null);

        // 验证结果
        assertNull(result);
    }

    /**
     * 测试用例TC006：两个链表都为空
     * 预期结果：返回null
     */
    @Test
    public void testGetIntersectionNode_BothNull() {
        // 创建被测对象并执行测试
        lc160 solution = new lc160();
        ListNode result = solution.getIntersectionNode(null, null);

        // 验证结果
        assertNull(result);
    }

    /**
     * 测试用例TC007：
     * 预期结果：返回相交节点
     */
    @Test
    public void testGetIntersectionNode_MiddleIntersection2() {
        // 构建公共部分
        ListNode common = new ListNode(3);

        // 构建链表A: 4 -> 1 -> 8 -> 4 -> 5
        ListNode headA = common;

        // 构建链表B: 5 -> 6 -> 1 -> 8 -> 4 -> 5
        ListNode headB = new ListNode(2,common);

        // 创建被测对象并执行测试
        lc160 solution = new lc160();
        ListNode result = solution.getIntersectionNode(headA, headB);

        // 验证结果
        assertNotNull(result);
        assertEquals(3, result.val);
    }
}
