package com.leetcode.code.lc100_200;

import java.util.Arrays;

public class lc123 {
    public int maxProfit(int[] prices) {
        //最多两笔交易，那我就分成两次“最多一笔交易”的问题
        //该方法时间复杂度为O（N²）超时了
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            int left = maxProfitOfOne(prices,0,i);
            int right = maxProfitOfOne(prices,i+1,prices.length-1);
            result = Math.max(result,left+right);
        }
        return result;
    }
    private int maxProfitOfOne(int[] prices,int start,int end){
        if (end<=start) return 0;
        int[][] dp = new int[prices.length][2];
        dp[start][0] = 0;
        dp[start][1] = -prices[start];
        for (int i = start+1; i <= end; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        return dp[end][0];
    }
    public int maxProfit2(int[] prices) {
        //最多两笔交易，那我就分成两次“最多一笔交易”的问题
        //但是该方法时间复杂度为O（N）
        int n = prices.length;
        if (n <= 1) return 0;
        // left[i] 表示 [0..i] 的最大一次交易收益（前缀dp，即lc121一维dp数组思想）
        int[] left = new int[n];
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - minPrice);
        }
        // right[i] 表示 [i..n-1] 的最大一次交易收益（后缀dp）
        int[] right = new int[n];
        int maxPrice = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            right[i] = Math.max(right[i + 1], maxPrice - prices[i]);
        }
        // 枚举分割点
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, left[i] + (i + 1 < n ? right[i + 1] : 0));
        }
        return res;
    }
    public int maxProfit3(int[] prices){
        //dp，多个状态
        if (prices.length<=1) return 0;
        int[][] dp = new int[prices.length][5];
        /*
        0：没有操作 （其实我们也可以不设置这个状态）
        1：第一次持有股票
        2：第一次不持有股票
        3：第二次持有股票
        4：第二次不持有股票
        */
        //dp数组如何初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
//        int result = 0;
//        for (int i = 0; i < dp[prices.length-1].length; i++) {
//            result = Math.max(result,dp[prices.length-1][i]);
//        }
//        return result;
        return dp[prices.length-1][4];
    }
}
