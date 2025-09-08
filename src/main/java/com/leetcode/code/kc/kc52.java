package com.leetcode.code.kc;

import java.util.Scanner;

public class kc52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int types = scanner.nextInt();
        int pkgSize = scanner.nextInt();
        int[] weight = new int[types];
        int[] values = new int[types];
        for (int i = 0; i < types; i++) {
            weight[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }
        //动态规划
        int[] dp = new int[pkgSize+1];
        for (int i = 0; i < types; i++) {
            for (int j = 0; j <= pkgSize; j++) {
                if (weight[i]<=j){
                    dp[j] = Math.max(dp[j],dp[j-weight[i]]+values[i]);
                }
            }
        }
        System.out.println(dp[pkgSize]);
    }
}
