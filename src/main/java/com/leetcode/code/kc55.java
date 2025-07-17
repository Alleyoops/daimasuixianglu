package com.leetcode.code;

import java.util.Scanner;

/*
字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，
请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
 */
public class kc55 {
    //思路：整体翻转，再局部翻转
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        //1.翻转整体
        char[] str = s.toCharArray();
        reverseString(str,0,str.length-1);
        //2.翻转局部
        reverseString(str,0,n-1);
        reverseString(str,n,str.length-1);
        System.out.println(str);
    }
    public static void reverseString(char[] arr, int start, int end){
        while (start<end){
            char c = arr[start];
            arr[start] = arr[end];
            arr[end] = c;
            start++;
            end--;
        }
    }
}
