package com.leetcode.code.lc400_600;

import java.util.ArrayList;
import java.util.List;

public class lc491 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> findSubsequences(int[] nums) {
        used = new boolean[nums.length];//默认为false
        backTrack(nums,0);
        return result;
    }
    private void backTrack(int[] nums,int startIndex){
        //判断是否加入结果集
        if (path.size()>=2) result.add(new ArrayList<>(path));
        //终止条件可不写，自动终止
        //if (startIndex==nums.length) return;

        //当前层次处理逻辑
        for (int i = startIndex; i < nums.length; i++) {
            //当前层次去重
            //注意：重复的元素不一定只是在num[i]的前一个，因为没有也不能对原数组进行排序操作
            //如何判断num[i]前面存在与num[i]相同的元素
            boolean pass = false;
            if (i>0){
                for (int j = startIndex; j < i; j++) {
                    if (nums[j]==nums[i]&&path.isEmpty()) {
                        if (!used[j]){
                            pass = true;
                            break;
                        }

                    }
                }
            }
            if (pass) continue;

            //是否加入path
            if (path.isEmpty()||nums[i]>=path.getLast()) {
                path.add(nums[i]);
                used[i] = true;
                backTrack(nums,i+1);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
