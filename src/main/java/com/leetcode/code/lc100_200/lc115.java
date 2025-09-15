package com.leetcode.code.lc100_200;

public class lc115 {
    int result = 0;

    public static void main(String[] args) {
        lc115 lc = new lc115();
        System.out.println(lc.numDistinct2("babgbag","bag"));
    }
    public int numDistinct(String s, String t) {
        //回溯法，超时
        backTrack(s,t,0,new StringBuilder());
        return result;
    }
    public void backTrack(String s, String t, int startIndex,StringBuilder sb){
        //终止条件
        if (sb.length()==t.length()){
            result++;
            return;
        }
        //处理逻辑
        for (int j = startIndex; j < s.length(); j++) {
            if (s.charAt(j)==t.charAt(sb.length())){
                sb.append(s.charAt(j));
//                System.out.println(sb.toString());
                backTrack(s,t,j+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public int numDistinct2(String s, String t){
        //dp
        int[][] dp = new int[t.length()+1][s.length()+1];
        //dp[i][j]表示下标i-1、j-1之前s的子序列中t的个数
        //初始化
        for (int i = 0; i < s.length(); i++) {
            if (t.charAt(0)==s.charAt(i)){
                dp[0][i] += dp[0][i]+1;
            }
        }
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = i; j < s.length()+1; j++) {
                if (t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
