package com.leetcode.code.lc400_600;
//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
public class lc459 {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abcdabcd"));
    }
    //1、暴力解法（外循环遍历到中间位置即可）
    public static boolean repeatedSubstringPattern(String s) {
        int n0 = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.length()%(i+1)!=0) continue;
            //判断子串能否构成原字符串
            int l = i+1;//子串长度
            int n = s.length()/l;//子串个数
            int n1 = 0;
            for (int j = 0; j < n; j++) {
                int n2 = 0;
                for (int k = 0; k < l; k++) {
                    if (s.charAt(k)==s.charAt(k+j*l)){
                        n2++;
                    }
                }
                if (n2==l) n1++;
            }
            if (n1==n) return true;
        }
        return false;
    }
    //2、KMP算法
    //判断字符串s是否由重复子串组成，只要两个s拼接在一起，里面还出现一个s的话，就说明是由重复子串组成
    /*
     * 充分条件：如果字符串s是由重复子串组成的，那么它的最长相等前后缀不包含的子串一定是s的最小重复子串。
     * 必要条件：如果字符串s的最长相等前后缀不包含的子串是s的最小重复子串，那么s必然是由重复子串组成的。
     * 推得：当字符串s的长度可以被其最长相等前后缀不包含的子串的长度整除时，不包含的子串就是s的最小重复子串。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static boolean repeatedSubstringPattern2(String s) {
        // if (s.equals("")) return false;
        // 边界判断（可以去掉，因为题目给定范围是1 <= s.length <= 10^4）
        int n = s.length();
        // Step 1.构建KMP算法的前缀表
        int[] next = new int[n]; // 前缀表的值表示 以该位置结尾的字符串的最长相等前后缀的长度
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) // 只要前缀后缀还不一致，就根据前缀表回退j直到起点为止
                j = next[j - 1];
            if (s.charAt(i) == s.charAt(j))
                j++;
            next[i] = j;
        }
        // Step 2.判断重复子字符串
        if (next[n - 1] > 0 && n % (n - next[n - 1]) == 0) { // 当字符串s的长度可以被其最长相等前后缀不包含的子串的长度整除时
            return true; // 不包含的子串就是s的最小重复子串
        } else {
            return false;
        }
    }

}
