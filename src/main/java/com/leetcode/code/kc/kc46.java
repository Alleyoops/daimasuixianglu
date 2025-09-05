package com.leetcode.code.kc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
小明是一位科学家，他需要参加一场重要的国际科学大会，
以展示自己的最新研究成果。他需要带一些研究材料，
但是他的行李箱空间有限。
这些研究材料包括实验设备、文献资料和实验样本等等，
它们各自占据不同的空间，并且具有不同的价值。
小明的行李空间为 N，问小明应该如何抉择，才能携带最大价值的研究材料，
每种研究材料只能选择一次，并且只有选与不选两种选择，不能进行切割。
输入描述：
第一行包含两个正整数，第一个整数 M 代表研究材料的种类，第二个正整数 N，代表小明的行李空间。
第二行包含 M 个正整数，代表每种研究材料的所占空间。
第三行包含 M 个正整数，代表每种研究材料的价值
输出描述;
输出一个整数，代表小明能够携带的研究材料的最大价值。
 */
public class kc46 {
    static int max = 0;//最大价值
    static int curN = 0;//当前背包空间
    static List<Integer> path = new ArrayList<>();
    public static void main(String[] args) {
        int M,N;//种类和行李空间
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        int[] zones = new int[M];
        for (int i = 0; i < M; i++) {
            zones[i] = scanner.nextInt();
        }
        int[] values = new int[M];
        for (int i = 0; i < M; i++) {
            values[i] = scanner.nextInt();
        }
        maxValueBT(N,zones,values,0);
        System.out.println(max);
        System.out.println(maxValueDP(N, M, zones, values));
        System.out.println(maxValueDP_OneDimension(N, M, zones, values));
    }
    //回溯法Backtrack（超时）
    private static void maxValueBT(int N, int[] zones, int[] values, int start){
        //终止条件
        if (curN>N) return;
        else {
            int n = 0;
            for (Integer i : path) {
                n+=values[i];
            }
            max = Math.max(max,n);
        }

        //处理逻辑
        for (int i = start; i < zones.length; i++) {
            curN+=zones[i];
            path.add(i);
            maxValueBT(N,zones,values,i+1);
            curN-=zones[i];
            path.removeLast();
        }
    }
    //背包问题，动态规划（二维数组）
    private static int maxValueDP(int N,int M,int[] zones,int[] values){
        //M个物品，N个背包容量；dp[i][j]表示任选0-i号物品在空间j下的最大价值
        int[][] dp = new int[M][N+1];
        //初始化：第一个物品放进不同容量的背包的最大价值
        for (int i = 0; i <= N; i++) {
            if (zones[0]<=i) dp[0][i] = values[0];
        }
        //递推关系式
        for (int i = 1; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                //对物品j分为放与不放
                //1、不放：最大价值为dp[i-1][j]
                //2、放：最大价值为dp[i-1][j-zones[i]]+values[i]（前提是空间能放得下物品i）
                if (zones[i]>j){
                    //放不下物品i
                    dp[i][j] = dp[i-1][j];
                }else {
                    //放得下但是可以选择放与不放
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-zones[i]]+values[i]);
                }
            }
        }
        return dp[M-1][N];
    }
    //背包问题，动态规划（一维滚动数组，减小空间复杂度）
    private static int maxValueDP_OneDimension(int N,int M,int[] zones,int[] values){
        //相当于重复利用（更新）二维数组的每一层
        int[] dp = new int[N+1];
        //初始化：第一个物品放进不同容量的背包的最大价值
        for (int i = 0; i <= N; i++) {
            if (zones[0]<=i) dp[i] = values[0];
        }
        //递推关系式
        for (int i = 1; i < M; i++) {
            //拷贝一份当前dp，防止调用dp[j-zones[i]]时不是上一层层的dp
            //还有一种方法，内层for循环倒序遍历可以避免：
//            for(int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
//                dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
//
//            }
            int[] temp = Arrays.copyOf(dp,dp.length);
            for (int j = 1; j <= N; j++) {
                //对物品j分为放与不放
                //1、不放：最大价值为dp[i-1][j]
                //2、放：最大价值为dp[i-1][j-zones[i]]+values[i]（前提是空间能放得下物品i）
                if (zones[i]<=j){
                    //放得下但是可以选择放与不放
                    dp[j] = Math.max(temp[j],temp[j-zones[i]]+values[i]);
                }
            }
        }
        return dp[N];
    }
}
