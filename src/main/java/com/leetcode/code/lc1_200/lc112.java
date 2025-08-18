package com.leetcode.code.lc1_200;

import com.leetcode.util.TreeNode;

public class lc112 {
    public boolean hasPathSum(TreeNode root,int targetSum){
        if (root == null){
            return false;
        }
        targetSum -= root.val;

        //叶子节点
        if (root.left == null && root.right == null){
            return targetSum == 0;
        }
        //非叶子节点
        //对比lc257，隐含了回溯，此处因为targetSum属于基本类型，传递给函数时属于值传递，不会改变原变量的值
        //基本数据类型（如int, boolean等）是值传递，但对象引用是引用传递（lc257）
        if (root.left!= null){
            boolean left = hasPathSum(root.left, targetSum);
            if (left) return true;//已经找到，提前返回
        }
        if (root.right!=null){
            boolean right = hasPathSum(root.right,targetSum);
            if (right) return true;//已经找到，提前返回
        }
        return false;
    }
}
