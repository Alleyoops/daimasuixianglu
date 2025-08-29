package com.leetcode.code.lc400_600;

import java.util.*;

/*
本题有两个维度，h和k，看到这种题目一定要想如何确定一个维度，然后再按照另一个维度重新排列。

其实如果大家认真做了135. 分发糖果 (opens new window)，就会发现和此题有点点的像。

在135. 分发糖果 (opens new window)我就强调过一次，遇到两个维度权衡的时候，一定要先确定一个维度，再确定另一个维度。

如果两个维度一起考虑一定会顾此失彼。
 */
public class lc406 {
    public int[][] reconstructQueue(int[][] people) {
        //两个维度分开考虑，先按身高维度从大到小排序
        //注意：（身高相同k小的站前面）。升序排列，故在a[0] == b[0]的狀況下，會根據k值升序排列
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });
        //再按顺序维度插入队列
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(people);
    }
}
