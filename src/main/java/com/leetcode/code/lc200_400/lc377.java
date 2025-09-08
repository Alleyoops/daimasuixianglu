package com.leetcode.code.lc200_400;

public class lc377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        //抽象为lc70的爬楼梯问题
        //每次能往上爬的阶梯数就是nums里面那些数字,
        //那么问题转化为一个target阶的楼梯总共有多少种爬法.
        for (int i = 1; i < target + 1; i++) {
            for (int num : nums) {
                if (i >= num) {
                    //dp[i] + dp[i - num]中的dp[i]为0
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
