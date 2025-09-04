package com.leetcode.code.lc600above;

public class lc746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length<2) return 0;
        //dp[i]的定义：到达第i台阶所花费的最少体力为dp[i]
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length+1; i++) {
            dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        return dp[cost.length];
    }
}
