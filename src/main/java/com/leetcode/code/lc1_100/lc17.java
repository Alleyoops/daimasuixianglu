package com.leetcode.code.lc1_100;

import java.util.ArrayList;
import java.util.List;

public class lc17 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        //用字符串数组构造字母映射
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
        int[] indexes = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            indexes[i] = Integer.parseInt(String.valueOf(digits.charAt(i)));
        }
        List<String> result = new ArrayList<>();
        String temp = "";
        backTrack(result, temp,indexes,map,0);
        return result;
    }
    public static void backTrack(List<String> result,String temp,int[] indexes,String[] map,int startIndex){
        //终止条件
        if (temp.length()==indexes.length){
            result.add(temp);
            System.out.println("---");
            return;
        }
        //处理逻辑
        StringBuilder tempBuilder = new StringBuilder(temp);
        for (int i = startIndex; i < indexes.length; i++) {
            int index = indexes[startIndex];
            String characters = map[index];
            for (int j = 0; j < characters.length(); j++) {
                tempBuilder.append(characters.charAt(j));
                backTrack(result,temp,indexes,map,i+1);
                tempBuilder.deleteCharAt(tempBuilder.length()-1);
            }
        }
        temp = tempBuilder.toString();
    }
}
