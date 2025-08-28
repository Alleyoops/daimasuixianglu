package com.leetcode.code.lc1_100;

public class lc55 {
    public boolean canJump(int[] nums) {
        //外循环查找0
        for (int i = 0; i < nums.length; i++) {
            boolean t = false;
            if (nums[i]==0){
                if (i==0) {
                    //如果长度为1，那么0是可以的
                    return nums.length == 1;//
                }
                //向前查找
                int diff = 1;
                for (int j = i-1; j >= 0; j--) {
                    //如果0不在末尾
                    if (nums[j]>diff) {
                        t = true;
                        break;
                    }
                    //如果0在末尾
                    if (nums[j]==diff && i==nums.length-1){
                        t = true;
                        break;
                    }
                    diff++;
                }
                if (!t) return false;
            }
        }
        return true;
    }
    public boolean canJump2(int[] nums) {
        int step = 0;
        if (nums.length==1) return true;
        // 注意这里是小于等于step
        for (int i = 0; i <= step; i++) {
            //如果某个数的步长可以达到终点，返回
            step = Math.max(nums[i]+i,step);//更新当前最长步长
            if (step>=nums.length-1) return true;
        }
        return false;
    }
}
