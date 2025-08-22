package com.leetcode.code.lc1_100;

import java.util.ArrayList;
import java.util.List;
/*
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 */
public class lc93 {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length()<4) return result;
        //向s中插入分割点，判断每次分割后的当前字段是否合法
        StringBuilder sb = new StringBuilder(s);
        backTrack(0,sb,0);
        return result;
    }
    private void backTrack(int startIndex,StringBuilder sb,int dotCount){
        //终止条件
        if (dotCount==3){
            //判断最后一段是否合法
            if (isValid(sb,startIndex,sb.length()-1)) result.add(sb.toString());
            return;
        }
        //当前字段处理逻辑
        for (int i = startIndex; i < sb.length(); i++) {
            if (isValid(sb,startIndex,i)){
                sb.insert(i+1,'.');
                backTrack(i+2,sb,dotCount+1);
                sb.deleteCharAt(i+1);
            }else break;
        }
    }
    //编写合法函数
    private boolean isValid(StringBuilder sb, int start ,int end){
        if (start>end) return false;
        if (sb.charAt(start)=='0'&&start!=end) return false;
        int num = 0;
        for (int i = start;i<=end;i++){
            int digit = sb.charAt(i)-'0';
            num = num*10+digit;
            if (num>255) return false;
        }
        return true;
    }
}
