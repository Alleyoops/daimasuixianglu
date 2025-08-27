package com.leetcode.code.lc200_400;

public class lc376 {
    public int wiggleMaxLength(int[] nums) {
        int result = 1;
        if (nums.length==1) return result;
        //上一个差值
        int pre = 0;
        //当前差值
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] - nums[i - 1];
            //如果cur和pre为一正一负
            if (cur!=pre && pre==0){//开头时
                result++;
                pre = cur;
            }else if (cur*pre<0){//中间时，一正一负
                result++;
                pre = cur;
            }
        }
        return result;
    }
}
