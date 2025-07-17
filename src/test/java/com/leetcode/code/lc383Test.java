package com.leetcode.code;

import static org.junit.jupiter.api.Assertions.*;

import com.leetcode.code.lc383;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Iterator;

public class lc383Test {
    private lc383 solution;

    @BeforeEach
    public void setUp() {
        solution = new lc383();
    }

    @Test
    public void testCanConstruct_WithValidMagazine_ReturnsTrue() {
        String ransomNote = "aa";
        String magazine = "aab";
        
        boolean result = solution.canConstruct(ransomNote, magazine);
        
        assertTrue(result);
    }

    @Test
    public void testCanConstruct_WithMissingCharacters_ReturnsFalse() {
        String ransomNote = "aa";
        String magazine = "ab";
        
        boolean result = solution.canConstruct(ransomNote, magazine);
        
        assertFalse(result);
    }

    @Test
    public void testCanConstruct_WithEmptyRansomNote_ReturnsTrue() {
        String ransomNote = "";
        String magazine = "ab";
        
        boolean result = solution.canConstruct(ransomNote, magazine);
        
        assertTrue(result);
    }

    @Test
    public void testCanConstruct_WithEmptyMagazine_ReturnsFalse() {
        String ransomNote = "a";
        String magazine = "";
        
        boolean result = solution.canConstruct(ransomNote, magazine);
        
        assertFalse(result);
    }

    @Test
    public void testCanConstruct_WithIdenticalStrings_ReturnsTrue() {
        String ransomNote = "abc";
        String magazine = "abc";
        
        boolean result = solution.canConstruct(ransomNote, magazine);
        
        assertTrue(result);
    }

    @Test
    public void testCanConstruct_WithInsufficientCharacterCount_ReturnsFalse() {
        String ransomNote = "aaa";
        String magazine = "aa";
        
        boolean result = solution.canConstruct(ransomNote, magazine);
        
        assertFalse(result);
    }
}
