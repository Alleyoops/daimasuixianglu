package com.leetcode.code.lc1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc39 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{8, 6, 7},6));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        //对candidates进行冒泡升序排序
        Arrays.sort(candidates);
        for (int candidate : candidates) {
            System.out.println(candidate);
        }
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
            sum+=candidates[i];
            if (sum>target) break;
            path.add(candidates[i]);
            backTrack(result,path,candidates,target,i,sum);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
