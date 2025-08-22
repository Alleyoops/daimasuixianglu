package com.leetcode.code.lc1_100;

import java.util.ArrayList;
import java.util.List;
/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 */
public class lc78 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            backTrack(nums,0,i+1);;
        }
        return result;
    }
    private void backTrack(int[] nums,int startIndex,int len){
        if (path.size()==len){
            result.add(new ArrayList<>(path));
            return;
        }
        //子集长度为len
        for (int i = startIndex; i < nums.length-(len-path.size())+1; i++) {
            path.add(nums[i]);
            backTrack(nums,i+1,len);
            path.removeLast();
        }
    }
}
