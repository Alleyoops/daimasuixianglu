package com.leetcode.code.lc100_200;

public class lc121 {
    public int maxProfit(int[] prices) {
        if (prices.length==1) return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]>min) res = Math.max(res,prices[i]-min);
            else min = prices[i];
        }
        return res;
    }
    //dp
    public int maxProfitDP(int[] prices){
        if (prices == null||prices.length==0) return 0;
        int length = prices.length;
        // dp[i][0]代表第i天 持有 股票的最大收益
        // dp[i][1]代表第i天 不持有 股票的最大收益
        int[][] dp = new int[length][2];
        //初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],prices[i]+dp[i-1][0]);
        }
        return Math.max(dp[length-1][0],dp[length-1][1]);
    }
}
