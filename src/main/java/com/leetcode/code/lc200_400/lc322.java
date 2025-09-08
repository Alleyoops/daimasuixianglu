package com.leetcode.code.lc200_400;

import java.util.Arrays;
import java.util.Comparator;

public class lc322 {
    public static int coinChange(int[] coins, int amount) {
        //完全背包问题，但是求长度最小的组合
        //dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
        int[] dp = new int[amount+1];
        //初始化
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < amount+1; j++) {
                if (j>=coins[i]&&dp[j-coins[i]]<Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        if (dp[amount]==Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
