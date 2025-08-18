package com.leetcode.code.lc400_600;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lc530 {
    public int getMinimumDifference(TreeNode root) {
        //中序遍历-递归法 得到升序数组
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        //solution
        //初始化int为整数最大值
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min,list.get(i)-list.get(i-1));
        }
        return min;
    }
    private void inOrder(TreeNode root,List<Integer> list){
        if (root==null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
}
