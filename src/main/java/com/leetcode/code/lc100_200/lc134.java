package com.leetcode.code.lc100_200;

public class lc134 {
    public static void main(String[] args) {
        int[] gas = new int[]{3,1,1};
        int[] cost = new int[]{1,2,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int res = 0;
        int start = 0;//起点
        int totalRes = 0;//全局有量剩余
        //贪心算法
        for (int i = 0; i < len; i++) {
            res+=gas[i]-cost[i];
            totalRes+=gas[i]-cost[i];
            if (res<0){
                res = 0;
                start = i+1;
            }
        }
        //全局油量够，就至少有一个起点
        if (totalRes<0) return -1;
        else return start;
    }
}
