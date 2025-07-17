package com.leetcode.code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class lc27Test {

    private lc27 solution;
    @Before
    public void setUp() throws Exception {
        solution = new lc27();
    }
    @Test
    public void testRemoveElement_EmptyArray() {
        // 测试空数组的情况

        int[] nums = {};
        int val = 1;
        int result = solution.removeElement(nums, val);
        assertEquals(0, result); // 期望返回值为 0
    }

    @Test
    public void testRemoveElement_NoMatch() {
        // 测试数组中没有匹配元素的情况

        int[] nums = {1, 2, 3};
        int val = 4;
        int result = solution.removeElement(nums, val);
        assertEquals(3, result); // 期望返回值为 3
        assertArrayEquals(new int[]{1, 2, 3}, nums); // 数组内容不变
    }

    @Test
    public void testRemoveElement_AllMatch() {
        // 测试数组中所有元素都匹配的情况

        int[] nums = {2, 2, 2};
        int val = 2;
        int result = solution.removeElement(nums, val);
        assertEquals(0, result); // 期望返回值为 0

    }

    @Test
    public void testRemoveElement_PartialMatch() {
        // 测试数组中部分元素匹配的情况

        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int result = solution.removeElement(nums, val);
        assertEquals(2, result); // 期望返回值为 2

    }

    @Test
    public void testRemoveElement_WithDuplicates() {
        // 测试数组中存在重复元素的情况

        int[] nums = {1, 1, 2, 2, 3, 3};
        int val = 2;
        int result = solution.removeElement(nums, val);
        assertEquals(4, result); // 期望返回值为 4

    }

    @Test
    public void testRemoveElement2_emptyArray() {
        // 测试用例1：空数组
        int[] nums = {};
        int val = 0;
        lc27 solution = new lc27();
        int result = solution.removeElement2(nums, val);
        assertEquals(0, result); // 预期返回值为0
    }

    @Test
    public void testRemoveElement2_noTargetValue() {
        // 测试用例2：数组中无目标值
        int[] nums = {1, 2, 3};
        int val = 4;
        lc27 solution = new lc27();
        int result = solution.removeElement2(nums, val);
        assertEquals(3, result); // 预期返回值为3
    }

    @Test
    public void testRemoveElement2_allTargetValues() {
        // 测试用例3：数组中全是目标值
        int[] nums = {1, 1, 1};
        int val = 1;
        lc27 solution = new lc27();
        int result = solution.removeElement2(nums, val);
        assertEquals(0, result); // 预期返回值为0
    }

    @Test
    public void testRemoveElement2_partialTargetValues() {
        // 测试用例4：数组中部分为目标值
        int[] nums = {1, 2, 3, 2, 4};
        int val = 2;
        lc27 solution = new lc27();
        int result = solution.removeElement2(nums, val);
        assertEquals(3, result); // 预期返回值为3
    }

    @Test
    public void testRemoveElement2_singleElementEqualToVal() {
        // 测试用例5：数组长度为1，且元素等于val
        int[] nums = {1};
        int val = 1;
        lc27 solution = new lc27();
        int result = solution.removeElement2(nums, val);
        assertEquals(0, result); // 预期返回值为0
    }

    @Test
    public void testRemoveElement2_singleElementNotEqualToVal() {
        // 测试用例6：数组长度为1，且元素不等于val
        int[] nums = {1};
        int val = 2;
        lc27 solution = new lc27();
        int result = solution.removeElement2(nums, val);
        assertEquals(1, result); // 预期返回值为1
    }
}