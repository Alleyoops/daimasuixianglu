package com.leetcode.code.lc400_600;

import java.util.Arrays;

public class lc455 {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        if (s.length==0) return result;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int k : s) {
            if (i < g.length &&  k >= g[i]) {
                result++;
                i++;
            }
        }
        return result;
    }
}
