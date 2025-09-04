package com.leetcode.code.lc200_400;

public class lc343 {
    public int integerBreak(int n) {
        //dp[i]：分拆数字i，可以得到的最大乘积为dp[i]。
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {//求每一个dp
            dp[i] = 0;
            for (int j = 1; j <= (i+1)/2; j++) {//每个dp的因数范围是1~i-1
                dp[i] = Math.max(Math.max(dp[j],dp[i]),Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
