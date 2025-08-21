package com.leetcode.code.lc1_100;

import java.util.*;
/*
给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用 一次 。
注意：解集不能包含重复的组合。
 */
public class lc40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        //对candidates进行冒泡升序排序
        Arrays.sort(candidates);
        if (candidates[0]>target) return result;
        if (candidates[0]==target) {
            path.add(target);
            result.add(path);
            return result;
        }
        backTrack(result,path,candidates,target,0,0);
        return result;
    }
    public static void backTrack(List<List<Integer>> result,List<Integer> path,int[] candidates, int target,int startIndex,int sum){
        //判断终止条件，跳出当前递归层
        if (sum==target){
            result.add(new ArrayList<>(path));//一定要new，不能添加同一个引用
            return;
        }
        //当前层处理逻辑
        for (int i = startIndex; i < candidates.length; i++) {
            if (i>startIndex&&candidates[i]==candidates[i-1]) continue;//！！！
            if (sum+candidates[i]>target) break;
            path.add(candidates[i]);
            backTrack(result,path,candidates,target,i+1,sum+candidates[i]);//！！！
            path.removeLast();
        }
    }
}
