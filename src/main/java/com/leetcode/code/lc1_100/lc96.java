package com.leetcode.code.lc1_100;

public class lc96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            //外层循环计算所有dp
            for (int j = 1; j <= i; j++) {
                //内层循环计算dp[i]
                int left = j-1;
                int right = i-j;
                dp[i]+=(dp[left]*dp[right]);
            }
        }
        return dp[n];
    }
}
