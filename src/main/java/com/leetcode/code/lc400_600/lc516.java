package com.leetcode.code.lc400_600;

public class lc516 {
    public int longestPalindromeSubseq(String s) {
        //思路一：翻转之后求最长公共子序列就好了
        //翻转
        String s1 = new StringBuilder(s).reverse().toString();
        //求最长公共子序列
        int[][] dp = new int[s.length()+1][s1.length()+1];
        //dp[i][j]表示以i-1、j-1结尾的子串的最长公共子序列长度
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < s1.length() + 1; j++) {
                if (s.charAt(i-1)==s1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[s.length()][s1.length()];
    }
    public int longestPalindromeSubseq2(String s) {
        //思路二：用 dp[i][j] 表示字符串 s 的下标范围 [i,j] 内的最长回文子序列的长度
        int[][] dp = new int[s.length()][s.length()];//dp[i][i]都为1;
        //由于最终要得到dp[0][s.length-1]，那么i应该逆向循环，j正向循环且比i大
        for (int i = s.length()-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
            }
        }
        return dp[0][s.length()-1];
    }
}
