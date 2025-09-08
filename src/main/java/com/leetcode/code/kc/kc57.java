package com.leetcode.code.kc;

import java.util.Scanner;

public class kc57 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//台阶总数
        int m = scanner.nextInt();//每次最大可爬台阶数
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (i>=j) {
                    dp[i] = dp[i]+dp[i-j];
                }
            }
        }
        System.out.println(dp[n]);
    }
}
