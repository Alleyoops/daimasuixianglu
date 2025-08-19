package com.leetcode.code.lc1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。
 */
public class lc18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //使用双指针法前先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //第一层剪枝
            if (nums[i] > target && nums[i] >= 0) break;
            //第一层去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                //第二层剪枝
                if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) break;
                //第二层去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) left++;
                    else if (sum > target) {
                        right--;
                    } else {
                        //找到四元组，计入result，去重
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2};
        int target = 0;
        List<List<Integer>> results = fourSum(nums, target);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }
}
