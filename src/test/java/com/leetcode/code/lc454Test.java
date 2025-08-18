package com.leetcode.code;

import com.leetcode.code.lc400_600.lc454;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class lc454Test {

    @Test
    public void testBasicCase() {
        lc454 solution = new lc454();

        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        // 可能的组合：
        // (0,0,0,0) -> 1+(-2)+(-1)+0 = 0
        // (1,0,0,1) -> 2+(-2)+(-1)+1 = 0
        // (0,1,0,1) -> 1+(-1)+(-1)+1 = 0
        // (1,1,1,0) -> 2+(-1)+2+(-3) = 0 (但这个例子不适用)
        // 实际有效组合为2个
        assertEquals(2, solution.fourSumCount(nums1, nums2, nums3, nums4));
    }

    @Test
    public void testAllZeros() {
        lc454 solution = new lc454();

        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};
        int[] nums3 = {0, 0};
        int[] nums4 = {0, 0};

        // 所有可能的组合都满足条件
        assertEquals(16, solution.fourSumCount(nums1, nums2, nums3, nums4));
    }

    @Test
    public void testEmptyArrays() {
        lc454 solution = new lc454();

        int[] nums1 = {};
        int[] nums2 = {};
        int[] nums3 = {};
        int[] nums4 = {};

        // 所有数组为空，没有可能的组合
        assertEquals(0, solution.fourSumCount(nums1, nums2, nums3, nums4));
    }

    @Test
    public void testSingleElementInEachArray() {
        lc454 solution = new lc454();

        int[] nums1 = {5};
        int[] nums2 = {5};
        int[] nums3 = {-5};
        int[] nums4 = {-5};

        // 5 + 5 + (-5) + (-5) = 0
        assertEquals(1, solution.fourSumCount(nums1, nums2, nums3, nums4));
    }

    @Test
    public void testNoValidCombinations() {
        lc454 solution = new lc454();

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        int[] nums3 = {5, 6};
        int[] nums4 = {7, 8};

        // 所有组合的和都不等于0
        assertEquals(0, solution.fourSumCount(nums1, nums2, nums3, nums4));
    }

}
