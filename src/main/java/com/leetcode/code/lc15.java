package com.leetcode.code;

import java.util.*;
import java.util.stream.Collectors;

/*
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。
 */
public class lc15 {
    public static void main(String[] args) {
        List<List<Integer>> lit = threeSum1(new int[]{2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10});
        System.out.println(lit);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        
        // 构建值到所有索引的映射
        for (int i = 0; i < nums.length; i++) {
            indexMap.putIfAbsent(nums[i], new ArrayList<>());
            indexMap.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 跳过重复的 i
            
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue; // 跳过重复的 j

                int target = -nums[i] - nums[j];
                
                // 查找是否有 target，并且其索引大于 j
                if (indexMap.containsKey(target)) {
                    for (int k : indexMap.get(target)) {
                        if (k > j) {
                            List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                            triplet = new ArrayList<>(triplet);
                            Collections.sort(triplet);
                            set.add(triplet);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    //双指针法
    public static List<List<Integer>> threeSum1(int[] nums) {
        int left = 0;
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);//对数组升序排序
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] > 0) {
                return new ArrayList<>(set);
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }
            left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum>0){
                    right--;
                }
                else if (sum<0){
                    left++;
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    list.sort(Comparator.naturalOrder());
                    set.add(list);
                    right--;
                    left++;
                }
            }
        }
        return new ArrayList<>(set);
    }
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
