package com.leetcode.code;

import java.util.Arrays;

/*
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class lc977 {
    //暴力解法
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)Math.pow(nums[i],2);
        }
        Arrays.sort(nums);
        return nums;
    }
    //双指针法（前后指针）
    public int[] sortedSquares2(int[] nums) {
        int right = 0;
        int size = nums.length;
        int left = size-1;
        int[] nums2 = new int[left+1];
        for (int i = size-1; i >=0 ; i--) {
            if (Math.pow(nums[right],2)>=Math.pow(nums[left],2)){
                nums2[i] = (int)Math.pow(nums[right],2);
                right++;
            }
            else {
                nums2[i] = (int)Math.pow(nums[left],2);
                left--;
            }
        }
        return nums2;
    }
}
