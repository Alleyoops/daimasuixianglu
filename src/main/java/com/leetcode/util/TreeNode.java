package com.leetcode.util;

/**
 * 二叉树节点类
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    // 构造函数
    public TreeNode(){}
    public TreeNode(int val){this.val = val;}
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
