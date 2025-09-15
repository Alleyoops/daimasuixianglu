package com.leetcode.code.lc400_600;

public class lc583 {
    public int minDistance(String word1, String word2) {
        //即求最长公共子序列的长度，再用总长减去最长公共子序列的长度*2即可
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        //dp[i][j]表示i-1，j-1之前的序列的最长公共子序列的长度
        //初始化dp[0][0]本来就为0
        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return word1.length()+word2.length()-dp[word1.length()][word2.length()]*2;
    }
}
