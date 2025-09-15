package com.leetcode.code.lc1_100;


public class lc72 {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();
        int[][] dp = new int[word2.length()+1][word1.length()+1];
        //dp[i][j]表示i-1、j-1之前的子串1转化为子串2需要的最小的操作数
        //初始化第一行和第一列
        //初始行
        for (int i = 1; i < word1.length() + 1; i++) {
            if (word2.charAt(0)!=word1.charAt(i-1)){
                dp[1][i] = dp[1][i-1]+1;
            }else dp[1][i] = i-1;
        }
        //初始列
        for (int i = 1; i < word2.length() + 1; i++) {
            if (word1.charAt(0)!=word2.charAt(i-1)){
                dp[i][1] = dp[i-1][1]+1;
            }else dp[i][1] = i-1;
        }
        for (int i = 2; i < word2.length()+1; i++) {
            for (int j = 2; j < word1.length()+ 1; j++) {
                if (word2.charAt(i-1)==word1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[word2.length()][word1.length()];
    }
}
