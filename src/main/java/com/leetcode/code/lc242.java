package com.leetcode.code;

import java.util.HashMap;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
//字母异位词是通过重新排列不同单词或短语的字母而形成的单词或短语，并使用所有原字母一次。
public class lc242 {
    public boolean isAnagram(String s, String t) {
        //暴力解法
        int l1 = s.length();
        int l2 = t.length();
        if (l1 != l2 || l1 == 0) return false;
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        HashMap<String, Integer> hashMap1 = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < l1; i++) {
            if (!hashMap1.containsKey(String.valueOf(array1[i]))) {
                hashMap1.put(String.valueOf(array1[i]),1);
            } else {
                int num = hashMap1.get(String.valueOf(array1[i]));
                hashMap1.put(String.valueOf(array1[i]),++num);
            }
            if (!hashMap2.containsKey(String.valueOf(array2[i]))) {
                hashMap2.put(String.valueOf(array2[i]),1);
            } else {
                int num = hashMap2.get(String.valueOf(array2[i]));
                hashMap2.put(String.valueOf(array2[i]),++num);
            }

        }
        return hashMap1.equals(hashMap2);//equals()比较对象内容，==比较对象地址
    }

    //优化时间复杂度，代码也更精简，思路更好
    public boolean isAnagram2(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count: record) {
            if (count != 0) {               // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
                return false;
            }
        }
        return true;                        // record数组所有元素都为零0，说明字符串s和t是字母异位词
    }
}
