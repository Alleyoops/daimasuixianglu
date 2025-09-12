package com.leetcode.code.lc600above;

public class lc718 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        //dp[i][j]表示以nums[i]结尾和nums[j]结尾的最长重复子数组的长度
        int result = 0;//dp[i][j]是所有重复子数组的长度，故应该取最大值
        for (int i = 1; i < nums1.length+1; i++) {
            for (int j = 1; j < nums2.length+1; j++) {
                if (nums1[i-1]==nums2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result,dp[i][j]);
                }
            }
        }
        return result;
    }
}
