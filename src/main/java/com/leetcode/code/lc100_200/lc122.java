package com.leetcode.code.lc100_200;

public class lc122 {
    //贪心算法
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i]-prices[i-1];
            if (diff>0) sum+=diff;
        }
        return sum;
    }
    //dp
    public int maxProfitDP(int[] prices){
        //dp[i][0] 表示第 i 天 交易完后 手里 不持有 股票的最大利润，
        //dp[i][1] 表示第 i 天 交易完后 手里 持有 一支股票的最大利润（i 从 0 开始）。（注意是一支）
        int[][] dp = new int[prices.length][2];
        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //状态转移
            //1：当天最后手里不持有股票：或前一天不持有，或把手里的这支股票卖了
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //2：当天最后手里持有股票：或前一天就持有，或今天刚买入
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}
