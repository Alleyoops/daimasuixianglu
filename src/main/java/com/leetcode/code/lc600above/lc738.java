package com.leetcode.code.lc600above;

import java.util.stream.Stream;

public class lc738 {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(95));
    }
    public static int monotoneIncreasingDigits(int n) {
        if (n/10==0) return n;
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        int eqCount = 1;//记录前面相等数字的数量，以便确保找到相应的index
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i)<sb.charAt(i-1)){
                int index = 0;
                String s = "";
                if (eqCount>1){
                    index = i-eqCount+1;
                    s = sb.substring(0,index+1);
                }else {
                    index = i;
                    s = sb.substring(0,index+1);
                }
                int n0 = sb.charAt(index)-'0';
                int n1 = Integer.parseInt(s);
                n1 = n1-n0-1;
                n1 = (int) (n1*Math.pow(10,sb.length()-index-1))+(int)Math.pow(10,sb.length()-index-1)-1;
                return n1;
            }
            if (sb.charAt(i)!=sb.charAt(i-1)){
                eqCount = 1;
            }else eqCount++;

        }
        return n;
    }
}
