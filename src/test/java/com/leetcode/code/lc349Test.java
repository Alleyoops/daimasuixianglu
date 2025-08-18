package com.leetcode.code;

import com.leetcode.code.lc200_400.lc349;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * lc349类的单元测试类
 * 测试intersection方法的各种情况
 */
public class lc349Test {

    /**
     * 测试基本案例：nums1 = [1,2,2,1], nums2 = [2,2]
     * 预期输出：[2]
     * 验证函数能否正确处理重复元素并去重
     */
    @Test
    public void testBasicCase() {
        lc349 solution = new lc349();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] expected = {2};
        int[] result = solution.intersection(nums1, nums2);

        // 排序后比较，因为顺序不影响结果
        Arrays.sort(result);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试典型案例：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 预期输出：[4,9]
     * 验证函数能否正确处理典型输入并去重
     */
    @Test
    public void testTypicalCase() {
        lc349 solution = new lc349();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] expected = {4, 9};
        int[] result = solution.intersection(nums1, nums2);

        // 排序后比较，因为顺序不影响结果
        Arrays.sort(result);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试完全不相交的情况：nums1 = [1,2,3], nums2 = [4,5,6]
     * 预期输出：[]
     * 验证函数能否正确处理无交集的情况
     */
    @Test
    public void testNoIntersection() {
        lc349 solution = new lc349();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        int[] expected = {};
        int[] result = solution.intersection(nums1, nums2);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试两个数组完全相同的情况：nums1 = [1,2,3], nums2 = [1,2,3]
     * 预期输出：[1,2,3]
     * 验证函数能否正确处理完全相同的数组
     */
    @Test
    public void testIdenticalArrays() {
        lc349 solution = new lc349();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3};
        int[] expected = {1, 2, 3};
        int[] result = solution.intersection(nums1, nums2);

        // 排序后比较，因为顺序不影响结果
        Arrays.sort(result);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试nums1为空的情况：nums1 = [], nums2 = [1,2,3]
     * 预期输出：[]
     * 验证函数能否正确处理空输入
     */
    @Test
    public void testEmptyNums1() {
        lc349 solution = new lc349();
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        int[] expected = {};
        int[] result = solution.intersection(nums1, nums2);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试nums2为空的情况：nums1 = [1,2,3], nums2 = []
     * 预期输出：[]
     * 验证函数能否正确处理空输入
     */
    @Test
    public void testEmptyNums2() {
        lc349 solution = new lc349();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        int[] expected = {};
        int[] result = solution.intersection(nums1, nums2);
        assertArrayEquals(expected, result);
    }

    /**
     * 测试元素顺序不同的情况：nums1 = [1,2,3], nums2 = [3,2,1]
     * 预期输出：[1,2,3]
     * 验证函数能否正确处理不同顺序的输入
     */
    @Test
    public void testDifferentOrder() {
        lc349 solution = new lc349();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {3, 2, 1};
        int[] expected = {1, 2, 3};
        int[] result = solution.intersection(nums1, nums2);

        // 排序后比较，因为顺序不影响结果
        Arrays.sort(result);
        assertArrayEquals(expected, result);
    }
}
