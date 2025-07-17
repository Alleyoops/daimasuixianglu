package com.leetcode.code;

import java.util.HashMap;
import java.util.Map;

/*
 什么时候使用哈希法，当我们需要查询一个元素是否出现过，或者一个元素是否在集合里的时候，就要第一时间想到哈希法。
 */
public class lc1 {
    //暴力解法
    public int[] twoSum(int[] nums, int target) {

        int a=0,b=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target){
                    a=i;
                    b=j;
                }
            }
        }
        return new int[]{a,b};
    }

    //哈希法
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target-nums[i];
            if (map.containsKey(n)){
                res[0] = i;
                res[1] = map.get(n);
                break;
            }
            map.put(nums[i],i);//判断元素是否出现，这个元素就要作为key，所以数组中的元素作为key，有key对应的就是value，value用来存下标
        }
        return res;
    }
}
