package com.leetcode.code.lc1_100;

import java.util.*;

public class lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }
            else{
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}
