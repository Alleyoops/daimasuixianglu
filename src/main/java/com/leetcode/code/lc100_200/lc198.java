package com.leetcode.code.lc100_200;

import java.util.Arrays;

public class lc198 {
    public int rob(int[] nums) {
        //01背包问题，背包容量未知，但是最大可能值为总和
        int pkgSize = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][pkgSize+1];
        //初始化
        if (nums.length==1) return nums[0];
        for (int i = 0; i < pkgSize + 1; i++) {
            dp[0][i] = nums[0];
        }
        for (int i = 0; i < pkgSize + 1; i++) {
            dp[1][i] = Math.max(dp[0][i],nums[1]);
        }
        for (int i = 2; i < nums.length; i++) {//物品种类
            for (int j = 1; j < pkgSize+1; j++) {//背包容量
                if (nums[i]<=j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-2][j]+nums[i]);
                }
            }
        }
        return dp[nums.length-1][pkgSize];
    }
    public int rob2(int[] nums) {
        //不是背包问题，背包容量都不知道，普通dp问题罢了
        int[] dp = new int[nums.length];//dp[i]为包括i以内的容量可装的最大价值
        //初始化
        if (nums.length==1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for (int j = 2; j <nums.length; j++) {
                dp[j] = Math.max(dp[j-1],dp[j-2]+nums[j]);
        }
        return dp[nums.length-1];
    }
}
