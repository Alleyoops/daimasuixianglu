package com.leetcode.code.lc1_100;

public class lc53 {
    //注意：不要求返回数组，只返回其最大和
    public int maxSubArray(int[] nums) {
        //暴力循环遍历所有数组可能
        int max = -Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int res = -Integer.MAX_VALUE;
        int cur = 0;
        for (int j : nums) {
            cur += j;
            if (cur <= 0) {
                if (j > 0) {
                    cur = j;
                    res = cur;
                } else cur = 0;
            } else {
                if (cur > res) res = cur;
            }
        }
        if (res<0){
            for (int num : nums) {
                if (num>res) res = num;
            }
        }
        return res;
    }
    public int maxSubArray3(int[] nums) {
        int res = Integer.MIN_VALUE;//保存已知最大和
        int cur = 0;
        for (int n : nums) {
            cur+=n;
            res = Math.max(res,cur);
            //如果当前子数组和变为负数或0，说明从下一个元素开始可能会得到更大的和，所以重置cur为0
            if (cur<=0&&nums.length!=1) cur = 0;
        }
        return res;
    }
    public int maxSubArray4(int[] nums){
        if (nums.length==1) return nums[0];
        //dp[i]表示 以nums[i]结尾的连续子数组 的最大和
        int[] dp = new int[nums.length+1];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length+1; i++) {
            if (dp[i-1]>=0) {
                dp[i] = dp[i-1]+nums[i];
            }
            else if (dp[i-1]<0){
                dp[i] = nums[i];
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
