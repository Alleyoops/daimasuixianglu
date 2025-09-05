package com.leetcode.code.lc400_600;

import java.util.Arrays;
import java.util.Map;

public class lc416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2!=0) return false;
        int half = sum/2;
        //方法一：回溯遍历求和，找到与half相等的组合即可
        //回溯法超时，寄！
        return backtrack(nums,half,0,0);
    }
    private boolean backtrack(int[] nums,int n,int sum,int start){
        //终止条件
        if (sum==n) return true;
        //处理逻辑
        for (int i = start; i < nums.length; i++) {
            sum+=nums[i];
            if (backtrack(nums,n,sum,i+1)) {
                return true;
            }else {
                sum-=nums[i];
            }
        }
        return false;
    }

    //动态规划
    public boolean canPartitionDP(int[] nums) {
        //问题本质，能否把背包容量为half的背包刚好装满，而物品的体积值恰是其权重值
        //本题目也就是判断背包能装的最大价值是否等于其背包容量
        //第一步：求背包容量
        int pkgSize = 0;
        for (int num : nums) {
            pkgSize += num;
        }
        if (pkgSize%2!=0) return false;
        else pkgSize = pkgSize/2;
        //动态规划，解决01背包问题，使用滚动数组
        int[] dp = new int[pkgSize+1];
        //初始化，放第一个物品
        for (int i = 0; i < pkgSize+1; i++) {
            if (nums[0]<=i) dp[i] = nums[0];
        }
        //从第二个物品开始递推
        for (int i = 1; i < nums.length; i++) {
            for (int j = pkgSize; j >= 1; j--) {
                if (nums[i]<=j){
                    dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
                }
            }
        }
        return dp[pkgSize]==pkgSize;
    }
}
