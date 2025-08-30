package com.leetcode.code.lc400_600;

import java.util.Arrays;
import java.util.Comparator;

public class lc452 {
    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}));

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
        //打印数组
        for (int i = 0; i < points.length; i++) {
            System.out.println(Arrays.toString(points[i]));
        }
        int time = 0;
//        for (int i = 0; i < points.length; i++) {
//            for (int j = points.length-1; j >= i; j--) {
//                if (points[j][0]<=points[i][1]){
//                    time++;
//                    i=j;
//                    break;
//                }
//            }
//        }
        return time;
    }
}
