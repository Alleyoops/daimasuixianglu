package com.leetcode.code.lc400_600;

import java.util.Arrays;
import java.util.Collections;

public class lc494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum<target||-sum>target) return 0;

    }
}
