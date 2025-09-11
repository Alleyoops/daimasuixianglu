package com.leetcode.code.lc600above;

import java.util.Arrays;

public class lc674 {
    public int findLengthOfLCIS(int[] nums) {
        int result = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]) len++;
            else {
                result = Math.max(result,len);
                len = 1;
            }
            if (i== nums.length-1) result = Math.max(result,len);
        }
        return result;
    }
    public int findLengthOfLCISDP(int[] nums) {
        if (nums.length==1) return 1;
        //dp[i]表示以 下标i为结尾 的连续递增的 子序列 长度为dp[i]
        //注意是递增子序列的结尾是元素i
        int[] dp = new int[nums.length];
        int result = 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[i-1]) dp[i] = dp[i-1]+1;
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
