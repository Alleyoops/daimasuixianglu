package com.leetcode.code.lc200_400;

import java.util.Arrays;

public class lc300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length==1) return 1;
        //dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
        //注意是 以nums[i]结尾 的子序列
        int[] dp = new int[nums.length];
        //初始化
        Arrays.fill(dp,1);
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            //位置i的最长升序子序列等于j从0到i-1各个位置的最长升序子序列 + 1 的最大值。
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]) dp[i] = Math.max(dp[j]+1,dp[i]);
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
