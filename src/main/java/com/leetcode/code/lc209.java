package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

/*
给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class lc209 {
    //暴力解法 时间复杂度O(n2)无法通过
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target && (j-i+1) <= len){
                    len = j-i+1;
                    break;
                }
                if (i == 0 && j == nums.length-1 && sum < target)  len = 0 ;
            }
        }
        return len;
    }
    //滑动窗口法（本质是双指针）
    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int len;//窗口长度
        List<Integer> ans = new ArrayList<>();
        for (int right = 0 ; right <nums.length ; right++){
            sum += nums[right];
            /*
            这里很重要。我自己写的代码是用的if，后来结果怎么都不对
            参考答案使用的是while(我的代码和答案仅此处有差别)
            为什么是while：它在满足sum>=target条件时要多次执行花括号内代码，即多次缩小左边指针
            if的错误点在于缩小一次左边指针left后，sum仍然可能>=target，窗口大小还需要继续精简
            即针对每一次不同的右指针right，应该动态多次调节窗口大小(缩减left)而不是只有一次if语句
             */
            while (sum>=target){
                len = right-left+1;//满足要求时滑动窗口实时长度
                ans.add(len);//将所有的满足要求的结果加入list方便排序1取最小值
                sum-=nums[left];
                left++;
            }
            /*
            不要以为for里放一个while就以为是O(n^2)啊， 主要是看每一个元素被操作的次数，
            每个元素在滑动窗后进来操作一次，出去操作一次，
            每个元素都是被操作两次，所以时间复杂度是 2 × n 也就是O(n)。
             */
        }
        //求ans中最小元素
        if (!ans.isEmpty()){
            int min = ans.get(0);
            for (Integer an : ans) {
                if (an < min) {
                    min = an;
                }
            }
            return min;
        }
        else return 0;//list为空，说明没有符号要求的子数组，直接返回0；

    }

    public int minSubArrayLen3(int target, int[] nums) {
        // 滑动窗口
            int left = 0;
            int sum = 0;
            /*
            因为要求的是最小值，所以通过int result = Integer.MAX_VALUE;
            把结果初始值定在最大，直接在滑动的过程中始终保持结果是最小值
            (如果初始int result = 0;那么result在滑动中在增加，而又要求最小值，显然不好直接保持result始终为最小值
            例如
             int target = 15;
             int[] nums = {1, 2, 15, 4, 5, 6, 7, 8, 9, 10};
             滑到15时，result为1，更新到7,8时result又为2，如何保证不把result从更小的1变为2是个问题
             故若int result = Integer.MAX_VALUE;则result = Math.min(result, right - left + 1)不会在第一次循环时因为result = 0而始终为0
             也就是说int result = 0和result = Math.min(result, right - left + 1)存在冲突，导致result无法更新
             )
             */
            int result = Integer.MAX_VALUE;//之所以不为0，为了方便第一次循环更新result时不始终为0
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum >= target) {
                    result = Math.min(result, right - left + 1);
                    sum -= nums[left++];
                }
            }
            return result == Integer.MAX_VALUE ? 0 : result;
        }
}
