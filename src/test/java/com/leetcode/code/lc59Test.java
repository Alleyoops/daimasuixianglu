package com.leetcode.code;

import com.leetcode.code.lc1_200.lc59;
import org.junit.Test;

import static org.junit.Assert.*;

public class lc59Test {

    @Test
    public void testGenerateMatrix_n1() {
        lc59 solution = new lc59();
        int[][] expected = {{1}};
        int[][] actual = solution.generateMatrix(1);
        assertArrayEquals("当n=1时，应该返回单元素矩阵", expected, actual);
    }

    @Test
    public void testGenerateMatrix_n2() {
        lc59 solution = new lc59();
        int[][] expected = {{1,2},{4,3}};
        int[][] actual = solution.generateMatrix(2);
        assertArrayEquals("当n=2时，应该返回2x2的螺旋矩阵", expected, actual);
    }

    @Test
    public void testGenerateMatrix_n3() {
        lc59 solution = new lc59();
        int[][] expected = {{1,2,3},{8,9,4},{7,6,5}};
        int[][] actual = solution.generateMatrix(3);
        assertArrayEquals("当n=3时，应该返回3x3的螺旋矩阵", expected, actual);
    }

    @Test
    public void testGenerateMatrix_n4() {
        lc59 solution = new lc59();
        int[][] expected = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        int[][] actual = solution.generateMatrix(4);
        assertArrayEquals("当n=4时，应该返回4x4的螺旋矩阵", expected, actual);
    }

    @Test
    public void testGenerateMatrix_n0() {
        lc59 solution = new lc59();
        int[][] expected = {};
        int[][] actual = solution.generateMatrix(0);
        assertArrayEquals("当n=0时，应该返回空矩阵", expected, actual);
    }
}