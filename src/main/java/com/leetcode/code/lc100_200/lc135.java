package com.leetcode.code.lc100_200;

import java.util.Arrays;

public class lc135 {
    //这道题目一定是要确定一边之后，再确定另一边，
    //例如比较每一个孩子的左边，然后再比较右边，如果两边一起考虑一定会顾此失彼。
    public int candy(int[] ratings) {
        if (ratings.length==1) return 1;
        int[] nums = new int[ratings.length];
        nums[0] = 1;
        //先让右边比较左边
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i]>ratings[i-1]) nums[i] = nums[i-1]+1;
            else nums[i] = 1;
        }
        //再左边比较右边
        for (int i = ratings.length-2; i >=0 ; i--) {
            if (ratings[i]>ratings[i+1]) nums[i] = Math.max(nums[i],nums[i+1]+1);
            else {
                nums[i] = Math.max(nums[i],1);
            }
        }
        return Arrays.stream(nums).sum();
    }
}
