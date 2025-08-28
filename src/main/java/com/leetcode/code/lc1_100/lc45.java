package com.leetcode.code.lc1_100;

public class lc45 {
    public int jump(int[] nums) {
        int preStep = 0;//上一个最大步长，也是当前遍历i的最大范围
        int curStep = 0;//循环的目的就是寻找preStep内新的最大步长，用curStep保存
        int time = 0;//记录跳跃次数
        for (int i = 0; i < nums.length-1; i++) {
            curStep = Math.max(nums[i]+i,curStep);
            if (i==preStep){//当前新的最大步长新更新完毕，需要跳进下一个最大步长，次数加一
                time++;
                preStep = curStep;
                if (preStep >= nums.length - 1) { // 已经能到终点，直接返回
                    return time;
                }
            }
        }
        return time;
    }
}
