package com.leetcode.code.lc200_400;

import java.util.ArrayList;
import java.util.List;

public class lc216 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3,7));
    }
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(k,n,1);
        return result;
    }
    public static void backTrack(int k, int n, int startIndex){
        if (temp.size()==k){
            int sum = 0;
            for (Integer i : temp) {
                sum+=i;
            }
            if (sum==n) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = startIndex; i <= 9-(k-temp.size())+1; i++) {
            temp.add(i);
            backTrack(k,n,i+1);
            temp.removeLast();
        }
    }
}
