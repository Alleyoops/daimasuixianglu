package com.leetcode.code.lc1_100;

import java.util.ArrayList;
import java.util.List;

/*
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class lc46 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backTrack(nums);
        return result;
    }
    private void backTrack(int[] nums){
        if (path.size()==nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        //逻辑处理
        for (int i = 0; i < nums.length; i++) {
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
