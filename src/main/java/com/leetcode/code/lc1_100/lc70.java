package com.leetcode.code.lc1_100;

public class lc70 {
    public int climbStairs(int n) {
        if (n<=2) return n;
        //1确定数组即下标意义
        int[] dp = new int[n+1];
        //2确定递推公式
        //3初始化dp数组
        dp[1] = 1;
        dp[2] = 2;
        //4确定遍历顺序
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
        //5推导验证
    }
}
