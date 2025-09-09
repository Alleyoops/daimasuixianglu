package com.leetcode.code.lc200_400;

import java.util.Arrays;

public class lc213 {
    public int rob(int[] nums) {
        /*
        由于House[1]和House[n]相邻，它们不能同时被抢劫。
        因此，问题变成了要么抢劫House[1]-House[n-1]，要么抢劫House[2]-House[n]，
        具体取决于哪种选择能带来更多的钱。现在问题已经退化成了已经解决的House Robber问题。
         */
        if (nums.length==1) return nums[0];
        if (nums.length==2) return Math.max(nums[0],nums[1]);
        if (nums.length==3) return Math.max(nums[0],Math.max(nums[1],nums[2]));
        //1:0~length-2
        int[] dp1 = new int[nums.length-1];//dp[i]为包括i以内的容量可装的最大价值
        dp1[0] = nums[0];
        dp1[1] = Math.max(dp1[0],nums[1]);
        for (int j = 2; j < nums.length-1; j++) {
            dp1[j] = Math.max(dp1[j-1],dp1[j-2]+nums[j]);
        }
        //2:1~length-1
        int[] dp2 = new int[nums.length];
        dp2[1] = nums[1];
        dp2[2] = Math.max(dp2[1],nums[2]);
        for (int j = 3; j < nums.length; j++) {
            dp2[j] = Math.max(dp2[j-1],dp2[j-2]+nums[j]);
        }
        System.out.println(Arrays.toString(dp2));
        return Math.max(dp1[nums.length-2],dp2[nums.length-2]);
    }
}
