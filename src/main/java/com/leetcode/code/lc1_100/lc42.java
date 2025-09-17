package com.leetcode.code.lc1_100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc42 {
    public int trap(int[] height) {
        //求出每个元素x左右两边比自己大的最大的元素a、b
        //然后该元素处可装容量为min(a，b)-x
        //第一步，求右边第一个比自己大的元素
        int[] rights = new int[height.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            helper(height, deque, rights, i);
        }
        while (!deque.isEmpty()){
            rights[deque.pop()] = -1;
        }
        //第二步，求左边第一个比自己大的元素
        int[] lefts = new int[height.length];
        for (int i = height.length-1; i >= 0; i--) {
            helper(height, deque, lefts, i);
        }
        while (!deque.isEmpty()){
            lefts[deque.pop()] = -1;
        }
//        System.out.println(Arrays.toString(rights));
//        System.out.println(Arrays.toString(lefts));
        //处理结果
        int result = 0;
        int[] maxRights = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            int k = rights[i];
            while (k!=-1&&rights[k]!=-1){
                k = rights[k];
            }
            maxRights[i] = k;
        }
//        System.out.println(Arrays.toString(maxRights));
        int[] maxLefts = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            int k = lefts[i];
            while (k!=-1&&lefts[k]!=-1){
                k = lefts[k];
            }
            maxLefts[i] = k;
        }
//        System.out.println(Arrays.toString(maxLefts));
        for (int i = 0; i < height.length; i++) {
            if (maxRights[i]!=-1&&maxLefts[i]!=-1){
                result+=Math.min(height[maxRights[i]],height[maxLefts[i]])-height[i];
            }
        }
        return result;
    }

    public void helper(int[] height, Deque<Integer> deque, int[] lefts, int i) {
        if (deque.isEmpty()||height[deque.peek()]>=height[i]){
            deque.push(i);
        }else {
            while (!deque.isEmpty()&&height[deque.peek()]<height[i]){
                lefts[deque.pop()] = i;
            }
            deque.push(i);
        }
    }
    public int trap2(int[] height) {
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int n = height.length;
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty()&&height[i]>height[deque.peek()]){
                int top = deque.pop();
                if (deque.isEmpty()) break;
                int left = deque.peek();
                int curWidth = i-left-1;
                int curHeight = Math.min(height[left],height[i])-height[top];
                ans+=curHeight*curWidth;
            }
            deque.push(i);
        }
        return ans;
    }
    public int trap3(int[] height) {
        //用O(n)来获得元素左右两边的最大值即可，所以选择用dp
        int[] rightDp = new int[height.length];//表示当前下表对应元素右边的最大值
        int[] leftDp = new int[height.length];
        //初始化，显然
        rightDp[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >= 0; i--) {
            rightDp[i] = Math.max(rightDp[i+1],height[i]);
        }
        leftDp[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftDp[i] = Math.max(leftDp[i-1],height[i]);
        }
        //计算容量
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans+=Math.min(leftDp[i],rightDp[i])-height[i];
        }
        return ans;
    }
}
