package com.leetcode.code.lc1_100;

import java.util.HashMap;

public class lc76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) return "";
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int count = 0;
        for (; right < m; right++) {
            char c = s.charAt(right);
            need[c]--;
            if (need[c]>=0){
                count++;
            }
            while (count==n){
                if(right-left+1<minLen){
                    minLen = right-left+1;
                    start = left;
                }
                char d = s.charAt(left);
                need[d]++;
                if (need[d]>0){
                    count--;
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}
