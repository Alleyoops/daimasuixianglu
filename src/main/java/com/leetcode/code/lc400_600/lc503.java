package com.leetcode.code.lc400_600;

import java.util.*;

public class lc503 {
    public int[] nextGreaterElements(int[] nums) {
        //暴力解法。如何遍历环形数组呢？使用while
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            int k = 1;
            while (k<n){
                if (nums[(i+k)%n]>a){
                    result[i] = nums[(i+k)%n];
                    break;
                }
                k++;
            }
        }
        return result;
    }
    public int[] nextGreaterElements2(int[] nums) {
        //单调栈
    }
}
