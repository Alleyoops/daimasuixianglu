package com.leetcode.code.lc600above;
import java.util.*;
public class lc763 {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();//记录每个字母最靠后的下标
        for (int i = s.length()-1; i >=0; i--) {
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c,i);
            }
        }
        int end = map.get(s.charAt(0));
        int count = 0;//计数器
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= end; i++) {
            count++;
            char c = s.charAt(i);
            if (map.get(c)>end){
                end = map.get(c);
            }
            if (i == end){
                list.add(count);
                count = 0;
                if (end<s.length()-1){
                    end = map.get(s.charAt(end+1));
                }
            }
        }
        return list;
    }
}
