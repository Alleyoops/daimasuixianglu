package com.leetcode.code.lc200_400;

import java.util.LinkedList;
import java.util.Queue;

public class lc225 {
    //一个对列来实现栈
    Queue<Integer> queue;
    public lc225() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);

    }

    public int pop() {
        //把被弹出元素前面的元素全部放到被弹出元素的后面
        for (int i = queue.size()-1; i >0 ; i--) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    public int top() {
        //把被弹出元素前面的元素全部放到被弹出元素的后面
        for (int i = queue.size()-1; i >0 ; i--) {
            queue.add(queue.poll());
        }
        //peek了之后记得还原队列
        int result = queue.peek();
        queue.add(result);
        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
