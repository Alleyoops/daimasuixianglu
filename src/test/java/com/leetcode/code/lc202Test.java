package com.leetcode.code;

import com.leetcode.code.lc200_400.lc202;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class lc202Test {

    @Test
    public void testHappyNumber_19_shouldReturnTrue() {
        lc202 solution = new lc202();
        assertTrue(solution.isHappy(19), "19 should be a happy number");
    }

    @Test
    public void testNotHappyNumber_2_shouldReturnFalse() {
        lc202 solution = new lc202();
        assertFalse(solution.isHappy(2), "2 is not a happy number");
    }

    @Test
    public void testInput1_shouldReturnTrue() {
        lc202 solution = new lc202();
        assertTrue(solution.isHappy(1), "1 is the terminal happy number");
    }

    @Test
    public void testInput0_shouldReturnFalse() {
        lc202 solution = new lc202();
        assertFalse(solution.isHappy(0), "0 is not a happy number");
    }

    @Test
    public void testHappyNumber_7_shouldReturnTrue() {
        lc202 solution = new lc202();
        assertTrue(solution.isHappy(7), "7 is also a happy number");
    }

//    @Test
//    public void testNegativeNumber_shouldReturnFalse() {
//        lc202 solution = new lc202();
//        assertFalse(solution.isHappy(-1), "-1 is invalid input and not happy number");
//    }
}
