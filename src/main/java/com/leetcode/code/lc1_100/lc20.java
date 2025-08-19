package com.leetcode.code.lc1_100;

import java.util.Objects;
import java.util.Stack;

public class lc20 {
    public static void main(String[] args) {
        System.out.println(isValid("[(){}]"));

    }

    public static boolean isValid(String s) {
        if (Objects.equals(s, "")) return true;
        Stack<Character> stack = new Stack<>();
        //将s转为字符数组
        char[] arr = s.toCharArray();
        int len = arr.length;
        if (len % 2 != 0) return false;
        for (char b : arr) {
            switch (b) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')', ']', '}':
                    if (stack.empty() ||stack.pop() != b) return false;
            }

        }
        return stack.empty();
    }
}
