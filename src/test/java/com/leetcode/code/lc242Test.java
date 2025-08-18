package com.leetcode.code;

import com.leetcode.code.lc200_400.lc242;
import org.junit.Test;

import static org.junit.Assert.*;

public class lc242Test {

    @Test
    public void testIsAnagram_TC01_NormalAnagram() {
        lc242 solution = new lc242();
        assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    @Test
    public void testIsAnagram_TC02_NotAnagram() {
        lc242 solution = new lc242();
        assertFalse(solution.isAnagram("rat", "car"));
    }

    @Test
    public void testIsAnagram_TC03_EmptyStrings() {
        lc242 solution = new lc242();
        assertFalse(solution.isAnagram("", ""));
    }

    @Test
    public void testIsAnagram_TC04_SingleDifferentChar() {
        lc242 solution = new lc242();
        assertFalse(solution.isAnagram("a", "b"));
    }

    @Test
    public void testIsAnagram_TC05_MultipleSameChars() {
        lc242 solution = new lc242();
        assertFalse(solution.isAnagram("aacc", "ccac"));
    }

    @Test
    public void testIsAnagram_TC06_ReversedOrder() {
        lc242 solution = new lc242();
        assertTrue(solution.isAnagram("abcde", "edcba"));
    }

    @Test
    public void testIsAnagram_TC07_DifferentLengths() {
        lc242 solution = new lc242();
        assertFalse(solution.isAnagram("abc", "abcd"));
    }

    @Test
    public void testIsAnagram_TC08_RepeatChars() {
        lc242 solution = new lc242();
        assertTrue(solution.isAnagram("aaaabbbb", "bbbbaaaa"));
    }
}
