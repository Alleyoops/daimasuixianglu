package com.leetcode.code.lc600above;

import java.util.ArrayDeque;


public class lc1047 {
    public static void main(String[] args) {
        System.out.println(reverseStr(new char[]{'a','c','c','a','b','c'}));
        System.out.println(removeDuplicates("accabc"));
    }
    public static String removeDuplicates(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (deque.isEmpty()) {
                deque.push(c);
                continue;
            }
            if (c == deque.peek()){
                deque.pop();
            }else deque.push(c);
        }
        //栈弹出
        char[] arr = new char[deque.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = deque.pop();
        }
        return reverseStr(arr);

    }

    public static String reverseStr(char[] arr){
        int right = arr.length-1;
        for (int i = 0; i < arr.length/2; i++) {
            char temp = arr[i];
            arr[i] = arr[right];
            arr[right] = temp;
            right--;
        }
        return String.copyValueOf(arr);
    }
}
