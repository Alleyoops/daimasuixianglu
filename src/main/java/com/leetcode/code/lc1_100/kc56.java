package com.leetcode.code.lc1_100;

import java.util.Scanner;

public class kc56 {
    //多重背包问题
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt();//背包容量
        int N = scanner.nextInt();//物品种类数
        int[][] infos = new int[3][N];//0：每种物品重量，1：每种物品价值，2：每种物品的数量上限
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                infos[i][j] = scanner.nextInt();
            }
        }
        //动态规划，多重背包问题
        int[] dp = new int[C+1];//dp[i]表示背包容量为i时能装下的物品的最大价值
        for (int i = 0; i < N; i++) {
            if (infos[2][i]>0){
                for (int j = C; j >= 0; j--) {
                    if (j>=infos[0][i]&&infos[2][i]>0){
                        if (dp[j]<dp[j-infos[0][i]]+infos[1][i]) {
                            dp[j] = dp[j-infos[0][i]]+infos[1][i];
                        }
                    }
                }
                infos[2][i]--;
                i--;
            }
        }
        System.out.println(dp[C]);
    }
}
