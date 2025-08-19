package com.leetcode.code.lc100_200;

/*
给你一个字符串 s ，请你反转字符串中 单词 的顺序。
单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class lc151 {
    public static void main(String[] args) {
        String s = reverseWords2("   happy  new year  ");
        System.out.println(s);
    }
    public static String reverseWords(String s) {
        String[] arr = s.trim().split(" +");//正则匹配一个或多个空格(trim()：去除字符串前后空格；)
        int j = arr.length-1;
        for (int i = 0; i < arr.length/2; i++) {
            String buff = arr[i];
            arr[i] = arr[j];
            arr[j] = buff;
            j--;
        }
        return String.join(" ",arr).trim();
    }
    public static String reverseWords2(String s) {
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;//空格的index
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    private static void reverseString(StringBuilder sb, int start, int end) {
        while (start<end){
            char c = sb.charAt(start);
            sb.setCharAt(start,sb.charAt(end));
            sb.setCharAt(end,c);
            start++;
            end--;
        }
    }

    private static StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length()-1;
        while (s.charAt(start)==' ') start++;//去首
        while (s.charAt(end)==' ') end--;//去尾
        StringBuilder sb = new StringBuilder();
        while (start<=end){
            char c = s.charAt(start);
            if (s.charAt(start)!=' '||sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
}
