package com.leetcode.code;

import java.util.*;

//给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
public class lc349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int j : nums1) {
            for (int k : nums2) {
                if (j - k == 0) {
                    set.add(j);
                    break;
                }
            }
        }

//        int[] res2 = set.stream().mapToInt(Integer::intValue).toArray();

        int[] res = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            res[i] = integer;
            i++;
        }
        return res;
    }
}
