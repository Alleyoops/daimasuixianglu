package com.leetcode.code.lc100_200;

public class lc188 {
    public int maxProfit(int k, int[] prices) {
        //最多完成k笔交易 damn！
        //那就根据lc123的规律总结出来dp数组和递推公式
        if (prices.length<=1) return 0;
        int[][] dp = new int[prices.length][k*2+1];
        //初始化
        for (int i = 1; i < k*2+1; i+=2) {
            dp[0][i] = -prices[0];
        }
        //递推
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < 2*k+1; j++) {
                if (j%2==1) dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]-prices[i]);
                else dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]+prices[i]);
            }
        }
        return dp[prices.length-1][2*k];
    }

}
