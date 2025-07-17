package com.leetcode.code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class lc704Test {

    private lc704 lc704;

    @Before
    public void setUp() {
        lc704 = new lc704();
    }

    @Test
    public void search_TargetLessThanAllElements_ReturnsNegativeOne() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 0;
        assertEquals(-1, lc704.search(nums, target));
    }

    @Test
    public void search_TargetGreaterThanAllElements_ReturnsNegativeOne() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 6;
        assertEquals(-1, lc704.search(nums, target));
    }

    @Test
    public void search_TargetExistsInLeftHalf_ReturnsCorrectIndex() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 2;
        assertEquals(1, lc704.search(nums, target));
    }

    @Test
    public void search_TargetExistsInRightHalf_ReturnsCorrectIndex() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 4;
        assertEquals(3, lc704.search(nums, target));
    }

    @Test
    public void search_TargetEqualsMiddleElement_ReturnsCorrectIndex() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;
        assertEquals(2, lc704.search(nums, target));
    }

    @Test
    public void search_TargetDoesNotExist_ReturnsNegativeOne() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 6;
        assertEquals(-1, lc704.search(nums, target));
    }

    @Test
    public void search_EmptyArray_ReturnsNegativeOne() {
        int[] nums = {};
        int target = 1;
        assertEquals(-1, lc704.search(nums, target));
    }
}