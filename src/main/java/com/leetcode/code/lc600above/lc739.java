package com.leetcode.code.lc600above;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc739 {
    //通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，
    //此时我们就要想到可以用单调栈了
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        //单调栈
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            //小于等于栈顶，往里push下标
            if (deque.isEmpty()||temperatures[i]<=temperatures[deque.peek()]) deque.push(i);
            else {
                //大于等于栈顶
                //把栈内小于当前值的内容弹出并记入result
                while (!deque.isEmpty()&&temperatures[deque.peek()]<temperatures[i]){
                    result[deque.peek()] = i-deque.pop();
                }
                deque.push(i);
            }
        }
        return result;
    }
}
