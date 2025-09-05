package com.leetcode.code.lc600above;

public class lc1049 {
    public int lastStoneWeightII(int[] stones) {
        //本题其实是尽量让石头分成重量相同的两堆（尽可能相同），相撞之后剩下的石头就是最小的。
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int pkg = sum/2;
        //不同背包容量，找到背包最多能装多少
        int[] dp = new int[pkg+1];
        for (int stone : stones) {//物品数
            for (int k = pkg; k >= 0; k--) {//背包容量
                if (stone <= k) dp[k] = Math.max(dp[k], dp[k - stone] + stone);
            }
        }
        return sum-2*dp[pkg];
    }
}
