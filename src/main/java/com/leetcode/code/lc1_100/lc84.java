package com.leetcode.code.lc1_100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc84 {
    public int largestRectangleArea(int[] heights) {
        //数组先左右两边各扩容一个0，目的是保证top、left、i（即能求宽度、高度）都有。
        //因为for循环里的处理逻辑每次都涉及到三个元素的比较，题目给出数组长度至少为1，
        //那么扩容后能保证数组长度至少为3，且扩容成0保证了数组递增时逻辑也能正常执行。
        int n = heights.length;
        int[] newHeight = new int[n+2];
        System.arraycopy(heights, 0, newHeight, 1, n);
        //本题是找每个柱子左右两边第一个小于该柱子的柱子。
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n+2; i++) {
            while (!deque.isEmpty()&&newHeight[deque.peek()]>newHeight[i]){
                int top = deque.pop();//右边界，目的是为了求矩形宽度
                if (deque.isEmpty()) break;
                int left = deque.peek();//求左边界，目的是为了求矩形宽度
                int curHeight = newHeight[top];
                int curWidth = i-left-1;
                ans = Math.max(ans,curWidth*curHeight);
            }
            deque.push(i);
        }
        return ans;
    }
}
