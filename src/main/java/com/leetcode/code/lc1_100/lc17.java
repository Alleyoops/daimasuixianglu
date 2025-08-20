package com.leetcode.code.lc1_100;

import java.util.ArrayList;
import java.util.List;

public class lc17 {
    String[] map = new String[]{
            "",//0
            "",//1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };
    List<String> result = new ArrayList<>();
    StringBuilder temp = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        //构造数字数组
        int[] indexes = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            indexes[i] = Integer.parseInt(String.valueOf(digits.charAt(i)));
        }
        //递归回溯
        backTrack(indexes,0);
        return result;
    }
    public void backTrack(int[] indexes,int startIndex){
        //终止条件
        if (temp.length()==indexes.length){
            result.add(temp.toString());
            return;
        }
        //处理逻辑
        //获取当前深度的数字对应的字母集合
        int index = indexes[startIndex];
        String s = map[index];
        //循环处理当前集合各个字母，构造复合条件的字符串
        for (int i = 0; i < s.length(); i++) {
            temp.append(s.charAt(i));
            //继续添加字符串的下一个字母。利用递归
            backTrack(indexes,startIndex+1);
            //回溯
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
