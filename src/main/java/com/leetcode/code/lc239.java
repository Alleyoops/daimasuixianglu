package com.leetcode.code;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class lc239 {
    //时间复杂度O(N)
    public int[] maxSlidingWindow(int[] nums, int k) {
        //使用双向队列
        Deque<Integer> deque = new LinkedList<>();
        if (k==1) return nums;
        int n = 0;
        int[] res = new int[nums.length-k+1];
        //队列中单调递减
        //第一个窗口
        for (int i = 0; i < k; i++) {
            //队尾添加元素
            if (deque.isEmpty()) {
                deque.addLast(nums[i]);
                continue;
            }
            //保持在加入队尾时，始终保持队列单调
            while (!deque.isEmpty()&&deque.peekLast()<nums[i]){
                deque.pollLast();//注意是从队尾移除小于num[i]的值
            }
            deque.addLast(nums[i]);
        }
        res[n++] = deque.peekFirst();
        //继续滑动窗口
        for (int i = k; i < nums.length; i++) {
            //每次滑动移除nums[i-k],加入nums[i]
            //如果要移除的正好是当前最大值（队首），则移除队首
            //如果不是最大值（队首），说明需要被移除的nums[i-k]已经在通过while循环加入队列时被通过单调队列的思想提前筛选出队列了，那么队首一定在当前窗口内
            //故只需看队首是否需要移除当前窗口，保证每次窗口的最大值是真的取自于当前窗口范围内的数值
            if (nums[i-k]==deque.peekFirst()){
                deque.removeFirst();

            }
            //保持在加入队尾时，始终保持队列单调
            while (!deque.isEmpty()&&deque.peekLast()<nums[i]){
                deque.pollLast();//注意是从队尾移除小于num[i]的值
            }
            deque.addLast(nums[i]);
            res[n++] = deque.getFirst();
        }
        return res;
    }
}
