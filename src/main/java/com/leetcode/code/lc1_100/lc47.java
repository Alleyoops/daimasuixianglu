package com.leetcode.code.lc1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class lc47 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums);
        return result;
    }
    private void backTrack(int[] nums){
        if (path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //逻辑处理
        //需要去重
        for (int i = 0; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backTrack(nums);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
