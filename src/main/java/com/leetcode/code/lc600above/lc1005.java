package com.leetcode.code.lc600above;

import java.util.Arrays;

public class lc1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //次数分配：
        //先把所有负数按从小到大取反
        //若k有多余，把最小正数或者是0取反直到k为0为止
        int minPositive = Integer.MAX_VALUE;//保存最小正数
        int sum = 0;//保存数组和
        //先对数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //先把所有负数进行取反（如果有）
            if (nums[i] < 0 && k > 0) {

                if (i==nums.length-1){
                    if (k % 2 != 0) {
                        sum -= 2 * nums[i];
                        k = 0;
                    }
                }else {
                    nums[i] = -nums[i];
                    k--;
                }
                sum += nums[i];
                continue;
            }
            //如果负数处理完毕，那么nums只含非负数，此时如果k还有多余，则对全局的最小非负数数不停取反
            //此时全局的最小非负数可能是最近被取反的负数（现在是正数），也可能是即将被取反的非负数
            if (nums[i] >= 0 && k > 0) {
                if (k % 2 != 0) {
                    if (i == 0) {
                        sum -= 2 * nums[i];
                        k = 0;
                    } else {
                        if (nums[i] <= nums[i - 1]) {
                            sum-= 2 * nums[i];
                            k = 0;
                        }else {
                            sum -= 2 * nums[i-1];
                            k = 0;
                        }
                    }
                }
                sum += nums[i];
                continue;
            }
            sum += nums[i];
        }
        return sum;
    }
}
