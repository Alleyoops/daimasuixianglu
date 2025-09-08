package com.leetcode.code.lc400_600;

public class lc474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] num = new int[strs.length][2];//保存每个字符串的0和1的字符个数
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            num[i][0] = getNumOf0Or1(s,'0');
            num[i][1] = getNumOf0Or1(s,'1');
        }
        //动态规划
        int [][] dp = new int[m+1][n+1];//表示从0-i个物品任选，装满背包容量为（m，n）的最大子集大小
        for (int i = 0; i < strs.length; i++) {//物品数
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (num[i][0]<=j&&num[i][1]<=k){
                        dp[j][k] = Math.max(dp[j][k],dp[j-num[i][0]][k-num[i][1]]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }
    private int getNumOf0Or1(String s,char c){
        int num = 0;
        if (c=='0'){
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)==c) num++;
            }
        } else if (c=='1') {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)==c) num++;
            }
        }
        return num;
    }
}
