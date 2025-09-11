package com.leetcode.code.lc600above;

public class lc714 {
    //动态规划（二维数组）
    public int maxProfit(int[] prices, int fee) {
        if (prices.length==1) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
    //动态规划（一维）
    public int maxProfit2(int[] prices, int fee) {
        if (prices.length==1) return 0;
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell,buy+prices[i]-fee);
            buy = Math.max(buy,sell-prices[i]);
        }
        return sell;
    }
    //贪心算法

}
