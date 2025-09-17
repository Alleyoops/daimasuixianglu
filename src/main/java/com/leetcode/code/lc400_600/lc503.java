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
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        //构造数组2
        int[] nums2 = new int[n*2];
        int k = 0;
        while (k<=2*n-1){
            nums2[k] = nums[k%n];
            k++;
        }
        //nums[121] nums2[121121]
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            if (deque.isEmpty()||nums2[deque.peek()]>nums2[i]){
                deque.push(i);
            }else {
                while (!deque.isEmpty()&&nums2[deque.peek()]<nums2[i]){
                    result[deque.pop()%n] = nums2[i];
                }
                deque.push(i);
            }
        }
        return result;
    }
    public int[] nextGreaterElements3(int[] nums) {
        //单调栈
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result,-1);
        //nums[121] nums2[121121]
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n*2; i++) {
            if (deque.isEmpty()||nums[deque.peek()%n]>nums[i%n]){
                deque.push(i);
            }else {
                while (!deque.isEmpty()&&nums[deque.peek()%n]<nums[i%n]){
                    result[deque.pop()%n] = nums[i%n];
                }
                deque.push(i);
            }
        }
        return result;
    }
}
