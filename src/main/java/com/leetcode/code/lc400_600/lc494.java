package com.leetcode.code.lc400_600;

public class lc494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (Math.abs(target)>sum) return 0;
        //不是简单的01背包问题，而是求有几种方法
        if ((sum+target)%2!=0) return 0;
        int pkg = (sum+target)/2;
        //dp数组，dp[i][j]表示背包容量为j时可装下物品0~i的最多方法数
        int[] dp = new int[pkg+1];
        //初始化
        dp[0]=1;//不放物品时dp为：1、0、0、0...
        for (int num : nums) {//一个物品、两个物品...
            for (int j = pkg; j >= 0; j--) {//最大方法数
                if (j >= num) {
                    dp[j] += dp[j - num];
                }
            }
        }
        return dp[pkg];
    }
}
