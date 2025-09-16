package com.leetcode.code.lc600above;

public class lc647 {
    public static void main(String[] args) {
        lc647 lc = new lc647();
        System.out.println(lc.countSubstrings("aba"));
    }
    public int countSubstrings(String s) {
        //双指针法（遍历每个回文中心，每个回文串或为偶数长度或为奇数长度对应于一个字符的回文中心或两个字符的回文中心）
        //第一种情况，回文串长度为偶数，即回文中心为两个字符
        int res = 0;
        for (int i = 0; i < s.length()-1; i++) {
            int left = i;
            int right = i+1;
            while (left>=0&&right <= s.length()-1&&s.charAt(left) == s.charAt(right) ){
                res++;
                left--;
                right++;
            }
        }
        //第二种情况，回文串长度为奇数，即回文中心为一个字符
        for (int i = 0; i < s.length(); i++) {
            res++;
            int left = i-1;
            int right = i+1;
            while (left>=0&&right<=s.length()-1&&s.charAt(left)==s.charAt(right)){
                res++;
                left--;
                right++;
            }
        }
        return res;
    }
}
