package com.leetcode.code;

import com.leetcode.code.lc200_400.lc209;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class lc209Test {
    private lc209 lc209;

    @Before
    public void setUp() {
        lc209 = new lc209();
    }

    @Test
    public void minSubArrayLen_EmptyArray_ReturnsZero() {
        int target = 7;
        int[] nums = {};
        int result = lc209.minSubArrayLen(target, nums);
        assertEquals(0, result);
    }

    @Test
    public void minSubArrayLen_SingleElementLessThanTarget_ReturnsZero() {
        int target = 7;
        int[] nums = {5};
        int result = lc209.minSubArrayLen(target, nums);
        assertEquals(0, result);
    }

    @Test
    public void minSubArrayLen_SingleElementEqualToTarget_ReturnsOne() {
        int target = 5;
        int[] nums = {5};
        int result = lc209.minSubArrayLen(target, nums);
        assertEquals(1, result);
    }

    @Test
    public void minSubArrayLen_AllElementsSumLessThanTarget_ReturnsZero() {
        int target = 15;
        int[] nums = {1, 2, 3};
        int result = lc209.minSubArrayLen(target, nums);
        assertEquals(0, result);
    }

    @Test
    public void minSubArrayLen_AllElementsSumEqualToTarget_ReturnsArrayLength() {
        int target = 6;
        int[] nums = {1, 2, 3};
        int result = lc209.minSubArrayLen(target, nums);
        assertEquals(3, result);
    }

    @Test
    public void minSubArrayLen_ExistsSubarrayWithSumGreaterThanTarget_ReturnsSubarrayLength() {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = lc209.minSubArrayLen(target, nums);
        assertEquals(2, result);
    }

    @Test
    public void minSubArrayLen_NoSubarrayWithSumGreaterThanTarget_ReturnsZero() {
        int target = 100;
        int[] nums = {1, 2, 3, 4, 5};
        int result = lc209.minSubArrayLen(target, nums);
        assertEquals(0, result);
    }

    @Test
    public void minSubArrayLen2_EmptyArray_ReturnsZero() {
        int target = 7;
        int[] nums = {};
        int result = lc209.minSubArrayLen2(target, nums);
        assertEquals(0, result);
    }

    @Test
    public void minSubArrayLen2_SingleElementLessThanTarget_ReturnsZero() {
        int target = 7;
        int[] nums = {5};
        int result = lc209.minSubArrayLen2(target, nums);
        assertEquals(0, result);
    }

    @Test
    public void minSubArrayLen2_SingleElementEqualToTarget_ReturnsOne() {
        int target = 5;
        int[] nums = {5};
        int result = lc209.minSubArrayLen2(target, nums);
        assertEquals(1, result);
    }

    @Test
    public void minSubArrayLen2_AllElementsSumLessThanTarget_ReturnsZero() {
        int target = 10;
        int[] nums = {1, 2, 3};
        int result = lc209.minSubArrayLen2(target, nums);
        assertEquals(0, result);
    }

    @Test
    public void minSubArrayLen2_AllElementsSumEqualToTarget_ReturnsArrayLength() {
        int target = 6;
        int[] nums = {1, 2, 3};
        int result = lc209.minSubArrayLen2(target, nums);
        assertEquals(3, result);
    }

    @Test
    public void minSubArrayLen2_SubarrayExists_ReturnsCorrectLength() {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = lc209.minSubArrayLen2(target, nums);
        assertEquals(2, result);
    }

    @Test
    public void minSubArrayLen2_MultipleSubarraysExist_ReturnsSmallestLength() {
        int target = 15;
        int[] nums = {1, 2, 15, 4, 5, 6, 7, 8, 9, 10};
        int result = lc209.minSubArrayLen2(target, nums);
        assertEquals(1, result);
    }
}