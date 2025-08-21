package com.leetcode.code.lc100_200;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
注意是分割 不是字母随意组合
 */
public class lc131 {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    private boolean isPalindrome(String s){
        //双指针法
        int right = s.length()-1;
        for (int left = 0; left < s.length()/2; left++) {
            if (s.charAt(left)!=s.charAt(right)) return false;
            right--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        backTrack(s,0);
        return result;
    }
    private void backTrack(String s,int startIndex){
        //终止条件：截取到s最后一个字母
        if (startIndex==s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        //当前层处理逻辑
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex,i+1);
            //判断是否回文，是则加入，否则跳过当前循环，增加sub长度
            if (isPalindrome(sub)){
                 path.add(sub);
            }else continue;
            //进入下一层
            backTrack(s,i+1);
            path.removeLast();
        }
    }
}
