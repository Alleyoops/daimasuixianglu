package com.leetcode.code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class lc977Test {
    private lc977 lc977;

    @Before
    public void setUp() {
        lc977 = new lc977();
    }

    @Test
    public void sortedSquares_EmptyArray_ReturnsEmptyArray() {
        int[] nums = {};
        int[] expected = {};
        assertArrayEquals(expected, lc977.sortedSquares(nums));
    }

    @Test
    public void sortedSquares_SingleElementArray_ReturnsSquaredElement() {
        int[] nums = {3};
        int[] expected = {9};
        assertArrayEquals(expected, lc977.sortedSquares(nums));
    }

    @Test
    public void sortedSquares_PositiveAndNegativeNumbers_ReturnsSortedSquares() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] expected = {0, 1, 9, 16, 100};
        assertArrayEquals(expected, lc977.sortedSquares(nums));
    }

    @Test
    public void sortedSquares_OnlyPositiveNumbers_ReturnsSortedSquares() {
        int[] nums = {1, 2, 3};
        int[] expected = {1, 4, 9};
        assertArrayEquals(expected, lc977.sortedSquares(nums));
    }

    @Test
    public void sortedSquares_OnlyNegativeNumbers_ReturnsSortedSquares() {
        int[] nums = {-3, -2, -1};
        int[] expected = {1, 4, 9};
        assertArrayEquals(expected, lc977.sortedSquares(nums));
    }

    @Test
    public void sortedSquares_DuplicateElements_ReturnsSortedSquares() {
        int[] nums = {-2, -2, 2, 2};
        int[] expected = {4, 4, 4, 4};
        assertArrayEquals(expected, lc977.sortedSquares(nums));
    }

    @Test
    public void sortedSquares2_EmptyArray_ReturnsEmptyArray() {
        int[] nums = {};
        int[] expected = {};
        int[] result = lc977.sortedSquares2(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void sortedSquares2_SinglePositiveElement_ReturnsSameElementSquared() {
        int[] nums = {1};
        int[] expected = {1};
        int[] result = lc977.sortedSquares2(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void sortedSquares2_SingleNegativeElement_ReturnsPositiveElementSquared() {
        int[] nums = {-1};
        int[] expected = {1};
        int[] result = lc977.sortedSquares2(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void sortedSquares2_AllPositiveNumbers_ReturnsSortedSquares() {
        int[] nums = {1, 2, 3};
        int[] expected = {1, 4, 9};
        int[] result = lc977.sortedSquares2(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void sortedSquares2_AllNegativeNumbers_ReturnsSortedSquares() {
        int[] nums = {-3, -2, -1};
        int[] expected = {1, 4, 9};
        int[] result = lc977.sortedSquares2(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void sortedSquares2_MixedNumbers_ReturnsSortedSquares() {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] expected = {0, 1, 9, 16, 100};
        int[] result = lc977.sortedSquares2(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void sortedSquares2_ContainsZero_ReturnsSortedSquares() {
        int[] nums = {-1, 0, 1};
        int[] expected = {0, 1, 1};
        int[] result = lc977.sortedSquares2(nums);
        assertArrayEquals(expected, result);
    }

    @Test
    public void sortedSquares2_DuplicateElements_ReturnsSortedSquares() {
        int[] nums = {-2, -2, 2, 2};
        int[] expected = {4, 4, 4, 4};
        int[] result = lc977.sortedSquares2(nums);
        assertArrayEquals(expected, result);
    }
}