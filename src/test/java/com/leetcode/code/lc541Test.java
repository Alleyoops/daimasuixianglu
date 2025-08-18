package com.leetcode.code;

import com.leetcode.code.lc400_600.lc541;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class lc541Test {
    @Test
    public void testReverseStr() {
        lc541 solution = new lc541();
        
        // 测试用例 1
        assertEquals("bacdfeg", solution.reverseStr("abcdefg", 2));
        
        // 测试用例 2
        assertEquals("bacd", solution.reverseStr("abcd", 2));
        
        // 测试用例 3
        assertEquals("edcba", solution.reverseStr("abcde", 5));
        
        // 测试用例 4: k=1
        assertEquals("acbde", solution.reverseStr("abcde", 1));
        
        // 测试用例 5: s长度为0
        assertEquals("", solution.reverseStr("", 3));
        
        // 测试用例 6: k大于s长度
        assertEquals("abcde", solution.reverseStr("abcde", 10));
    }
}