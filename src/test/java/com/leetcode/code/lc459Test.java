package com.leetcode.code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.leetcode.code.lc459;

/**
 * lc459Test class tests the repeatedSubstringPattern method of lc459 class.
 * This test class verifies various scenarios including normal cases, edge cases,
 * and special patterns to ensure the method works correctly for different inputs.
 */
public class lc459Test {

    private final lc459 solution = new lc459();
    
    /**
     * Test case: String can be formed by repeating a substring.
     * Input: "abab" - contains two repetitions of "ab"
     * Expected output: true
     */
    @Test
    public void testRepeatedSubstringPattern() {
        assertTrue(solution.repeatedSubstringPattern("abab"));
    }
    
    /**
     * Test case: String cannot be formed by repeating any substring.
     * Input: "aba" - no repeating pattern
     * Expected output: false
     */
    @Test
    public void testNoRepeatedSubstringPattern() {
        assertFalse(solution.repeatedSubstringPattern("aba"));
    }
    
    /**
     * Test case: String with all identical characters.
     * Input: "aaaaa" - each character is same, so can be considered as repetition
     * Expected output: true
     */
    @Test
    public void testAllSameCharacters() {
        assertTrue(solution.repeatedSubstringPattern("aaaaa"));
    }
    
    /**
     * Test case: Odd length string that cannot be divided into repeating substrings.
     * Input: "abcab" - incomplete pattern at end
     * Expected output: false
     */
    @Test
    public void testOddLengthNoPattern() {
        assertFalse(solution.repeatedSubstringPattern("abcab"));
    }
    
    /**
     * Test case: Empty string input.
     * Input: "" - empty string
     * Expected output: false
     */
    @Test
    public void testEmptyString() {
        assertFalse(solution.repeatedSubstringPattern(""));
    }
    
    /**
     * Test case: Single character string.
     * Input: "a" - only one character, no repetition possible
     * Expected output: false
     */
    @Test
    public void testSingleCharacter() {
        assertFalse(solution.repeatedSubstringPattern("a"));
    }
    
    /**
     * Test case: Multiple complete repetitions of a substring.
     * Input: "abcabcabc" - three repetitions of "abc"
     * Expected output: true
     */
    @Test
    public void testMultipleCompleteRepetitions() {
        assertTrue(solution.repeatedSubstringPattern("abcabcabc"));
    }
    
    /**
     * Test case: String with maximum possible valid substring length.
     * Input: "abcdabcd" - two repetitions of "abcd"
     * Expected output: true
     */
    @Test
    public void testMaxValidSubStringLength() {
        assertTrue(solution.repeatedSubstringPattern("abcdabcd"));
    }
    
    /**
     * Test case: Minimum possible substring length (1) with repetition.
     * Input: "aaa" - three repetitions of "a"
     * Expected output: true
     */
    @Test
    public void testMinSubStringLengthWithRepetition() {
        assertTrue(solution.repeatedSubstringPattern("aaa"));
    }
    
    /**
     * Test case: Case-sensitive check with mixed case characters.
     * Input: "AbcAbc" - two repetitions of "Abc"
     * Expected output: true
     */
    @Test
    public void testCaseSensitiveCheck() {
        assertTrue(solution.repeatedSubstringPattern("AbcAbc"));
    }
}
