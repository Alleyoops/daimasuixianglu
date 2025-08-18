package com.leetcode.code.lc600above;

public class lc704 {
    /*
    给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     */
    public int search(int[] nums, int target)
    {
        int mid = (nums.length-1)/2;
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            if(target<nums[mid]){
                right = mid-1;
                mid = (right+left)/2;
            }else if (target == nums[mid]){
                return mid;
            } else {
                left = mid+1;
                mid = (right+left)/2;
            }
        }
        return -1;
    }

}
