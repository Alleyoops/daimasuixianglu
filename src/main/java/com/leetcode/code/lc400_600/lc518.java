package com.leetcode.code.lc400_600;

import java.util.Arrays;

public class lc518 {
    public int change(int amount, int[] coins) {
        //完全背包问题，求方法数
        //dp[i][j]表示0~i种类物品装满容量为j的背包的最大方法数
        int[][] dp = new int[coins.length][amount+1];
        //初始化
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < amount + 1; i++) {
            if (i%coins[0]==0) dp[0][i] = 1;
        }
        System.out.println(Arrays.toString(dp[0]));
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j<coins[i]) dp[i][j] = dp[i-1][j];//不能放
                else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i]];//不放+放
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[coins.length-1][amount];
    }
    public int change2(int amount, int[] coins) {
        //完全背包问题，求方法数，一维滚动数组
        //dp[i][j]表示0~i种类物品装满容量为j的背包的最大方法数
        int[] dp = new int[amount+1];
        //初始化
        dp[0] = 1;
        for (int coin : coins) {
            /*
            01背包	每个物品只能用一次	从右往左遍历容量（防止重复用）
            完全背包	每个物品可以无限用	从左往右遍历容量（允许重复用）
             */
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    dp[j] = dp[j] + dp[j - coin];//不放+放
                    // （这里指的放是指先放一个，放完一个后剩余的空间依然可以再放物品i，故内循环从左往右循环更新）
                }
            }
        }
        return dp[amount];
    }
}
