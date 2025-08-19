package com.leetcode.code.lc100_200;

import com.leetcode.util.TreeNode;
/*
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class lc108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0) return null;
        if (nums.length==1) return new TreeNode(nums[0]);
        int left_len = 0;
        int right_len =0;
        if (nums.length%2==0){
            //偶数长度
            left_len = nums.length/2;
            right_len = nums.length/2-1;
        }else {
            //奇数长度
            left_len = nums.length/2;
            right_len = nums.length/2;
        }
        int[] lefts = new int[left_len];
        System.arraycopy(nums, 0, lefts, 0, left_len);
        int[] rights = new int[right_len];
        System.arraycopy(nums,nums.length/2+1,rights,0,right_len);

        int val = nums[nums.length/2];
        TreeNode root = new TreeNode(val);
        root.left = sortedArrayToBST(lefts);
        root.right = sortedArrayToBST(rights);
        return root;
    }
}
