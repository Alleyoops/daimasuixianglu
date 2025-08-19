package com.leetcode.code.lc1_100;

import com.leetcode.util.TreeNode;

import java.util.*;

/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树
要知道中序遍历下，输出的二叉搜索树节点的数值是有序序列。
有了这个特性，验证二叉搜索树，就相当于变成了判断一个序列是不是递增的了
 */
public class lc98 {
    public boolean isValidBST(TreeNode root) {
        //中序遍历-迭代法
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null||!stack.isEmpty()){
            if (node!=null){
                stack.add(node);
                node = node.left;
            }else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return isSorted(list);
    }
    private boolean isSorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i-1)) {
                return false;
            }
        }
        return true;
    }
    private void get(TreeNode treeNode, List<Integer> list){
        //左-中-右
        if (treeNode==null) return ;
        else {
            get(treeNode.left,list);
            list.add(treeNode.val);
            get(treeNode.right,list);
        }
    }
    public boolean isValidBST2(TreeNode root) {
        //中序遍历-递归法
        List<Integer> list = new ArrayList<>();
        get(root,list);
        return isSorted(list);
    }
}
