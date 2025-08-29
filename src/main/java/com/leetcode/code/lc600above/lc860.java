package com.leetcode.code.lc600above;

import java.util.HashMap;
import java.util.Map;

public class lc860 {
    public boolean lemonadeChange(int[] bills) {
        int[] wallet = new int[2];//
        for (int i = 0; i < bills.length; i++) {
            if (i==0&&bills[i]!=5) return false;
            if (bills[i]==5) wallet[0]++;
            if (bills[i]==10){
                if (wallet[0]<1) return false;
                wallet[0]--;
                wallet[1]++;
            }
            if (bills[i]==20){
                if (wallet[1]>=1&&wallet[0]>=1) {
                    wallet[1]--;
                    wallet[0]--;
                }
                else if (wallet[0]>=3){
                    wallet[0]-=3;
                }
                else return false;
            }
        }
        return true;
    }
}
