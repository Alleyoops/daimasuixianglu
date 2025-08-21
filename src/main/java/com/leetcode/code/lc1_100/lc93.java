package com.leetcode.code.lc1_100;

import java.util.ArrayList;
import java.util.List;
/*
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 */
public class lc93 {
    List<String> result = new ArrayList<>();
    StringBuilder sb_path = new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        backTrack(s,0,new StringBuilder());
        return result;
    }
    private void backTrack(String s,int startIndex,StringBuilder sb){
        //终止条件
        if (startIndex==s.length()&&sb_path.length()==s.length()+4){
            System.out.println("test");
            sb_path.deleteCharAt(sb_path.length()-1);
            result.add(sb_path.toString());
            return;
        }
        //处理逻辑
        for (int i = startIndex; i < s.length(); i++) {
            String sub = sb.append(s.charAt(i)).toString();
            if (sub.length()==4) break;
            int num = Integer.parseInt(sub);
            //符合要求的情况一：单独0
            if (num==0){
                sb_path.append(sub);
                sb_path.append(".");
                backTrack(s,i+1,new StringBuilder());
                sb_path.deleteCharAt(sb_path.length()-1);
                break;
            }
            //情况二：1~255
            if (1<=num&&num<=255){
                sb_path.append(sub);
                sb_path.append(".");
                backTrack(s,i+1,new StringBuilder());
                sb_path.deleteCharAt(sb_path.length()-1);
            }
        }
    }
}
