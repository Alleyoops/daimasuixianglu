package com.leetcode.code.lc1_100;

import java.util.*;

public class lc56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        if (intervals.length==1) return intervals;
        List<int[]> result = new ArrayList<>();
        int[] sub = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]<=sub[1]){
                sub[1] = Math.max(intervals[i][1],sub[1]);
            }
            else if (intervals[i][0]>sub[1]){
                result.add(Arrays.copyOf(sub,2));
                sub = intervals[i];
            }
            if (i == intervals.length-1) result.add(Arrays.copyOf(sub,2));
        }
        return result.toArray(new int[result.size()][2]);
    }
}
