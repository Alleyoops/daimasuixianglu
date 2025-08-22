package com.leetcode.code.lc1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class lc90 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums,0);
        return result;
    }
    private void backTrack(int[] nums,int startIndex){
        result.add(new ArrayList<>(path));
        //终止条件可省略
//        if (startIndex == nums.length){
//            return;
//        }
        //处理逻辑
        for (int i = startIndex; i < nums.length; i++) {
            if (i>startIndex && nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            backTrack(nums,i+1);
            path.removeLast();
        }
    }

    //使用used数组进行去重
    boolean[] used;
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        if (nums.length == 0){
            result.add(path);
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        subsetsWithDupHelper(nums, 0);
        return result;
    }

    private void subsetsWithDupHelper(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}
