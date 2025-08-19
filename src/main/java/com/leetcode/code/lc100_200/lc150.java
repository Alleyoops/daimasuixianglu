package com.leetcode.code.lc100_200;

import java.util.ArrayDeque;
import java.util.Deque;

/*
输入: ["2", "1", "+", "3", "*"]
输出: 9
解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 */
public class lc150 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }

    /*
    add 方法是 Queue 接口的一部分，用于将一个元素插入到队列的末尾。
    在 Deque 中，add 方法的作用是将元素添加到双端队列的尾部。

    push 方法是 Deque 接口的一部分，用于将一个元素插入到双端队列的头部。
    它模拟了栈的行为，将元素压入栈顶。
     */
    public static int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (String s : tokens) {
            switch (s) {
                case "+" -> deque.push(deque.pop() + deque.pop());
                case "-" -> deque.push((-deque.pop()) + deque.pop());
                case "*" -> deque.push(deque.pop() * deque.pop());
                case "/" -> {
                    int a = deque.pop();
                    int b = deque.pop();
                    deque.push(b / a);
                }
                default -> deque.push(Integer.valueOf(s));
            }
        }
        return deque.pop();
    }
}
