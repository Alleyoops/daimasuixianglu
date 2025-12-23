package com.leetcode.code.lc1_100;

import java.util.HashMap;

public class lc76 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tMap = new HashMap<>();
        //统计t的字母频率
        for(int i = 0;i<t.length();i++){
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        int left = -1;
        int minLen = s.length();
        int ansLeft = -1;
        int ansRight = s.length();
        for(int right = 0;right<=s.length()-1&&left<right;right++){
            if(check(s,t,tMap,left,right)){
                if(right-left<=minLen){
                    minLen = right-left;
                    ansLeft = left;
                    ansRight = right;
                }
                left++;
            }
        }
        return s.substring(ansLeft+1,ansRight);
    }
    public boolean check(String s,String t, HashMap<Character,Integer> tMap,int left,int right){
        if(right-left<t.length()) return false;
        for(int i = left+1;i<=right;i++){
            tMap.remove(s.charAt(i));
        }
        return tMap.isEmpty();
    }
}
