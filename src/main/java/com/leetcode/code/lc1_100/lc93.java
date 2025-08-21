package com.leetcode.code.lc1_100;

import java.util.ArrayList;
import java.util.List;
/*
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 */
public class lc93 {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        backTrack(s,0);
        return result;
    }
    private void backTrack(String s,int startIndex){
        //终止条件
        if (sb.length()==s.length()+4){
            result.add(sb.toString());
            return;
        }
        //处理逻辑
        for (int i = startIndex; i < 3; i++) {

        }
    }
}
