package com.leetcode.code.lc200_400;

public class lc392 {
    public boolean isSubsequence(String s, String t) {
        //暴力解法
        int start = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = start; j < t.length(); j++) {
                if (s.charAt(i)==t.charAt(j)){
                    len++;
                    start = j+1;
                    break;
                }
            }
        }
        return len == s.length();
    }
    public boolean isSubsequence2(String s, String t) {
        //最长公共子序列问题
        int[][] dp = new int[s.length()+1][t.length()+1];
        //dp[i][j]表示i-1和j-1之前的s和t的公共子序列的最长值
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < t.length()+1; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[s.length()][t.length()]==s.length();
    }
    public boolean isSubsequence3(String s, String t) {
        //双指针法
        int right = 0;
        int len = 0;
        for (int left = 0; left < s.length()&&right<t.length(); left++) {
            if (s.charAt(left)==t.charAt(right)){
                right++;
                len++;
            }
            else {
                left--;
                right++;
            }
        }
        return len == s.length();
    }
}
