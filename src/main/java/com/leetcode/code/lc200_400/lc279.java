package com.leetcode.code.lc200_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];//最少数量
        //初始化
        Arrays.fill(dp,n);
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {//容量
            for (int j = 1; j < n + 1; j++) {
                if (j*j<=i) dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
