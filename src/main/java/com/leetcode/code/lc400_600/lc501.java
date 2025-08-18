package com.leetcode.code.lc400_600;

import com.leetcode.util.TreeNode;

import java.util.*;

public class lc501 {
    public int[] findMode(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        inOrder(root,resultList);
        //统计众数
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer i : resultList) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()>max) {
                if (!list.isEmpty()) list.clear();
                list.add(entry.getKey());
                max = entry.getValue();
            }
            else if (entry.getValue()==max) list.add(entry.getKey());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    private void inOrder(TreeNode root,List<Integer> list){
        if (root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
