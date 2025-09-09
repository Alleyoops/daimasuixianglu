package com.leetcode.code.lc200_400;

import com.leetcode.util.TreeNode;

import java.util.*;

public class lc337 {
    public int rob(TreeNode root) {
        // 这道题是树形DP的入门题目，通过这道题目大家应该也了解了，
        // 所谓树形DP就是在树上进行递归公式的推导。
        //dp数组（dp table）以及下标的含义：
        //下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱。
        int[] dp = postOrder(root);
        return Math.max(dp[0],dp[1]);
    }
    private int[] postOrder(TreeNode root){
        //终止条件
        if (root==null) return new int[]{0,0};
        //左
        int[] left = postOrder(root.left);
        //右
        int[] right = postOrder(root.right);
        //中，逻辑处理
        int[] cur = new int[2];
        cur[0] = Math.max(left[1],left[0])+Math.max(right[1],right[0]);//不偷，那么左右孩子就可以偷，至于到底偷不偷一定是选一个最大的
        cur[1] = root.val+left[0]+right[0];//偷，那么左右孩子就不能偷
        return cur;
    }
}
