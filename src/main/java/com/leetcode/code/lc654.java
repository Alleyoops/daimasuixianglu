package com.leetcode.code;

import com.leetcode.util.TreeNode;

import java.awt.*;
import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

public class lc654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return getNode(0, nums.length-1,nums);

    }

    public TreeNode getNode(int left,int right,int[] nums){
        if (left>right) return null;
        if (left==right) return new TreeNode(nums[left]);

        Map.Entry<Integer,Integer> entry = getMax(nums,left,right);
        int max = entry.getKey();
        int indexOfMaxVal = entry.getValue();
        TreeNode root = new TreeNode(max);

        root.left = getNode(left,indexOfMaxVal-1,nums);
        root.right = getNode(indexOfMaxVal+1,right,nums);
        return root;
    }

    public Map.Entry<Integer,Integer> getMax(int[] nums, int left, int right) {
        int max = nums[left];
        int index = left;
        for (int i = left+1; i <= right; i++) {
            if (nums[i]>max) {
                max = nums[i];
                index = i;
            }
        }
        return Map.entry(max, index);
    }
}
