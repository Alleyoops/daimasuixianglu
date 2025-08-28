package com.leetcode.code.lc1_100;

public class lc53 {
    //注意：不要求返回数组，只返回其最大和
    public int maxSubArray(int[] nums) {
        //暴力循环遍历所有数组可能
        int max = -Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int res = -Integer.MAX_VALUE;
        int cur = 0;
        for (int j : nums) {
            cur += j;
            if (cur <= 0) {
                if (j > 0) {
                    cur = j;
                    res = cur;
                } else cur = 0;
            } else {
                if (cur > res) res = cur;
            }
        }
        if (res<0){
            for (int num : nums) {
                if (num>res) res = num;
            }
        }
        return res;
    }
    public int maxSubArray3(int[] nums) {
        int res = Integer.MIN_VALUE;//保存已知最大和
        int cur = 0;
        for (int n : nums) {
            cur+=n;
            res = Math.max(res,cur);
            //如果当前子数组和变为负数或0，说明从下一个元素开始可能会得到更大的和，所以重置cur为0
            if (cur<=0&&nums.length!=1) cur = 0;
        }
        return res;
    }
}
