package com.leetcode.code.lc400_600;

import java.util.*;

public class lc452 {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{1,2}, {3,4},{5,6},{7,8}}));

    }
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int time = 0;
        boolean[] flags = new boolean[points.length];//标记数组，默认false
        for (int i = points.length-1; i >= 0; i--) {
            if (!flags[i]){
                for (int j = i-1; j >= 0; j--) {
                    if (points[i][0]<=points[j][1]&& !flags[j]){
                        flags[j] = true;
                    }
                }
                time++;
            }
        }
        return time;
    }
}
