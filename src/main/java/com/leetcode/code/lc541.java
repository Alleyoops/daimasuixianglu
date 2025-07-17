package com.leetcode.code;
/*
给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */

import java.util.Arrays;

public class lc541 {
    public String reverseStr(String s, int k) {
        int len = s.length();
        for (int i = 0; i < len; ) {
            if (len-i >= k){
                System.out.println(i);
                String subStr = s.substring(i,i+k);
//                System.out.println(subStr);
                String pre = s.substring(0,i);
//                System.out.println(pre);
                String end = s.substring(i+k,len);
//                System.out.println(end);
                //翻转subStr
                char[] newSubStr1 = subStr.toCharArray();
                reverse(newSubStr1);
                s = pre.concat(new String(newSubStr1)).concat(end);
                System.out.println(s);
            }else {
                String subStr = s.substring(i,len);
                String pre = s.substring(0,i);
                char[] newSubStr1 = subStr.toCharArray();
                reverse(newSubStr1);
                s = pre.concat(new String(newSubStr1));
                System.out.println("ddd");
            }

            i+=2*k;
        }
        return s;
    }

    public static void reverse(char[] newSubStr1) {
        int right = newSubStr1.length-1;
        for (int j = 0; j < newSubStr1.length/2; j++) {
            char a = newSubStr1[j];
            newSubStr1[j] = newSubStr1[right];
            newSubStr1[right] = a;
            right--;
        }
    }
}
