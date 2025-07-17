package com.leetcode.code;

import java.util.Arrays;
import java.util.HashSet;

/*
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」 定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
 */
public class lc202 {
    public boolean isHappy(int n) {

        HashSet<Integer> hashSet = new HashSet<>();
        int numNext = n;
        while (true){
            numNext = getNextNumber(numNext);
            if (numNext==1) return true;
            if (!hashSet.contains(numNext)){
                hashSet.add(numNext);
            }else return false;
        }
    }
    public int sum(int n){
        //转为数字数组,使用Stream API进行转换
        String s = String.valueOf(n);
        int[] arr = s.chars().map(Character::getNumericValue).toArray();
        int sum = 0;
        for (int j : arr) {
            sum += (int) Math.pow(j, 2);
        }
        return sum;
    }
    //优化sum
    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

}
