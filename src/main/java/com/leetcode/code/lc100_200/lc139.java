package com.leetcode.code.lc100_200;

import java.util.Arrays;
import java.util.List;

public class lc139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //背包问题，排列或者爬阶梯思想，即背包在外循环，物品在内循环
        boolean[] dp = new boolean[s.length()+1];//背包容量为字符串长度，dp[i]表示是否能够有wordDict元素构成
        //初始化
        Arrays.fill(dp,false);
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (String str : wordDict) {
                if (i >= str.length()) {
                    String sub = s.substring(i - str.length(), i + 1);
                    if (sub.equals(str) && dp[i - str.length()]) dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
