package com.leetcode.code.lc400_600;

import java.util.Arrays;

public class lc435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0]==o2[0]) return Integer.compare(o1[1],o2[1]);
            return Integer.compare(o1[0],o2[0]);
        });
        int num = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]<intervals[i-1][1]){
                num++;
                intervals[i][1] = Math.min(intervals[i][1],intervals[i-1][1]);
            }
        }
        return num;
    }
}
