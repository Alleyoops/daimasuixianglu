package com.leetcode.code.kc;

import java.util.Scanner;

/*
给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
输入描述
输入一个字符串 s,s 仅包含小写字母和数字字符。
输出描述
打印一个新的字符串，其中每个数字字符都被替换为了number
 */
public class kc54 {//提交时注意改成Main类
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] str = scanner.nextLine().toCharArray();
        int n = 0;//数字计数器
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9'){
                n+=1;
            }
        }
        char[] newStr = new char[str.length+5*n];//新数组长度
        //双指针法
        int j = newStr.length-1;
        for (int i = str.length-1; i >= 0; i--) {//从后向前遍历
            if (str[i] >= 'a' && str[i] <= 'z' && i<=j){
                newStr[j] = str[i];
                j--;
            }
            if (str[i] >= '0' && str[i] <= '9' && i<=j){
                    newStr[j] = 'r';
                    newStr[j-1] = 'e';
                    newStr[j-2] = 'b';
                    newStr[j-3] = 'm';
                    newStr[j-4] = 'u';
                    newStr[j-5] = 'n';
                    j-=6;
            }
        }
        System.out.println(String.valueOf(newStr));
        scanner.close();
     }

}
