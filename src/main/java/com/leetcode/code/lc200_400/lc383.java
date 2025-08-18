package com.leetcode.code.lc200_400;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class lc383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> list1 = new ArrayList<>(ransomNote.chars()
                .mapToObj(c -> (char) c)
                .toList());
        List<Character> list2 = magazine.chars()
                .mapToObj(c -> (char) c)
                .toList();
        for (Character c : list2) {
            Iterator<Character> iterator = list1.iterator();
            while (iterator.hasNext()) {
                Character d = iterator.next();
                if (c.equals(d)) {
                    iterator.remove();
                    break;
                }
            }
        }

        return list1.isEmpty();
    }
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] array = new int[26];
        for (char c : magazine.toCharArray()){
            array[c-'a']+=1;
        }
        for (char c : ransomNote.toCharArray()){
            array[c-'a']-=1;
        }
        for(int i : array){
            if (i<0) return false;
        }

        return true;
    }

}
