package com.leetcode.code.lc200_400;

public class lc309 {
    public int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        /*
        思考第i天会有几个状态：
        0：持有股票
        1：不持有股票，即这一天卖出股票，第二天是冷冻期
        2：不持有股票，即今天肯定没有卖股票，第二天不是冷冻期
         */
        int[][] dp = new int[prices.length][3];
        //初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }
}
