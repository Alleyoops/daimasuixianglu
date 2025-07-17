package com.leetcode.code;
/*
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class lc28 {
    public static void main(String[] args) {
        System.out.println(strStr2("leetcode","g"));
    }
    //暴力解法
    public static int strStr1(String haystack, String needle) {
        int a = haystack.length();
        int b = needle.length();
        char[] s = haystack.toCharArray();
        char[] p = needle.toCharArray();
        for (int i = 0; i < a-b+1; i++) {
            int num = 0;
            for (int j = 0; j < b; j++) {
                if (p[j] == s[j+i] ){
                    num++;
                }
            }
            if (num == b) return i;
        }
        return -1;
    }

    //窗口滑动法
    public static int strStr2(String haystack, String needle) {
        int m = needle.length();
        // 当 needle 是空字符串时我们应当返回 0
        if (m == 0) {
            return 0;
        }
        int n = haystack.length();
        if (n < m) {
            return -1;
        }
        int i = 0;
        int j = 0;
        while (i < n - m + 1) {
            // 找到首字母相等
            while (i < n && haystack.charAt(i) != needle.charAt(j)) {
                i++;
            }
            if (i == n) {// 没有首字母相等的
                return -1;
            }
            // 遍历后续字符，判断是否相等
            i++;
            j++;
            while (i < n && j < m && haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {// 找到
                return i - j;
            } else {// 未找到
                i -= j - 1;
                j = 0;
            }
        }
        return -1;
    }
    //前缀表（不减一）Java实现
    public static int strStr3(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {//使用kmp算法的好处就是i不回退，而是一直往前
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;

    }

    //求前缀表
    private static void getNext(int[] next, String s) {
        int j = 0;//j指向前缀末尾位置，i指向后缀末尾位置
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))//子串前后缀不相同时
                j = next[j - 1];
            if (s.charAt(j) == s.charAt(i))//子串前后缀相同时
                j++;
            next[i] = j;
        }
        //【最浅显易懂的 KMP 算法讲解】https://www.bilibili.com/video/BV1AY4y157yL?vd_source=e251287207a879e2c359073d2109cb40
    }
}
