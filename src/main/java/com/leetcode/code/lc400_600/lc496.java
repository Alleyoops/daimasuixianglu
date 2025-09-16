package com.leetcode.code.lc400_600;

import java.util.*;

public class lc496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //暴力
        int[] result = new int[nums1.length];
        Arrays.fill(result,-1);
        for (int i = 0; i < nums1.length; i++) {
            int a = nums1[i];
            for (int k = 0; k < nums2.length; k++) {
                if (nums2[k] == a) {
                    for (int j = k; j < nums2.length; j++) {
                        if (nums2[j]>a){
                            result[i] = nums2[j];
                            break;
                        }
                    }
                }
                if (result[i]!=-1) break;
            }
        }
        return result;
    }
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        //单调栈
        int[] result = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            if (deque.isEmpty()||deque.peek()>=nums2[i]) deque.push(nums2[i]);
            else {
                while (!deque.isEmpty()&&deque.peek()<nums2[i]){
                    map.put(deque.pop(),nums2[i]);
                }
                deque.push(nums2[i]);
            }
        }
        while (!deque.isEmpty()){
            map.put(deque.pop(),-1);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
