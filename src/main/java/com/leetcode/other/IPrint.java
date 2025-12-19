package com.leetcode.other;

public interface IPrint {
    String str = "ans:";
    default void print(int a, int b){
        System.out.println(str+(a+b));
    };
}
