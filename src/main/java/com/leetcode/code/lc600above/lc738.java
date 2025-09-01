package com.leetcode.code.lc600above;

public class lc738 {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(3331));
    }
    public static int monotoneIncreasingDigits(int n) {
        if (n/10==0) return n;
        StringBuilder sb = new StringBuilder(String.valueOf(n));

        for (int i = 1; i < sb.length(); i++) {
//            if (i+2<=sb.length()-1&&sb.charAt(i)==sb.charAt(i-1)&&sb.charAt(i+1)<sb.charAt(i)){
//                String s = sb.substring(0,i+1);
//                int n0 = sb.charAt(i)-'0';
//                int n1 = Integer.parseInt(s);
//                System.out.println(n1);
//                System.out.println(n0);
//                n1 = n1-n0-1;
//                n1 = (int) (n1*Math.pow(10,sb.length()-i-1))+(int)Math.pow(10,sb.length()-i-1)-1;
//                return n1;
//            }
            if (sb.charAt(i)<sb.charAt(i-1)){
                String s = sb.substring(0,i+1);
                int n0 = sb.charAt(i)-'0';
                int n1 = Integer.parseInt(s);
                n1 = n1-n0-1;
                n1 = (int) (n1*Math.pow(10,sb.length()-i-1))+(int)Math.pow(10,sb.length()-i-1)-1;
                return n1;
            }

        }
        return n;
    }
}
