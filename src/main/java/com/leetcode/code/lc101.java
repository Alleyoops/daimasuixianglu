package com.leetcode.code;

import com.leetcode.util.TreeNode;

import java.util.*;

public class lc101 {
    //要比较的是根节点的两个子树是否是相互翻转的，进而判断这个树是不是对称树，
    // 所以要比较的是两个树、所以要比较的是两个树、所以要比较的是两个树
    public boolean isSymmetric(TreeNode root) {
        //递归
        //DFS。左右中遍历
        //比较根节点的左子树和右子树是否镜像对称
        if (root==null) return true;
        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;
        return compareLAndR(leftTree,rightTree);

    }
    //比较外侧：左子树的左节点VS右子树的右节点
    //比较内侧：左子树的右节点VS右子树的左节点
    public boolean compareLAndR(TreeNode left, TreeNode right){

        boolean out,in;
        if (left==null&&right==null) {
            return true;
        }
        else if (left==null||right==null) {
            return false;
        } else if (left.val!= right.val){
            return false;
        } else {
            out = compareLAndR(left.left,right.right);
            in = compareLAndR(left.right,right.left);
            return in&&out;
        }
    }

    //迭代法，层序遍历
    public boolean compare(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();//双向队列
        queue.add(root);
        while (!queue.isEmpty()){
            int layerNum = queue.size();
            for (int i = 0; i < layerNum; i++) {
                TreeNode node = queue.poll();
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            int size = queue.size();
            if (size%2!=0) return false;
            for (int i = 0; i < size / 2; i++) {
                TreeNode left = queue.pollLast();
                TreeNode right = queue.pollFirst();
                if (left.val!=right.val) return false;
                TreeNode leftLeft = left.left;
                TreeNode rightRight = right.right;
                if (leftLeft!=null&&rightRight!=null){
                    if (leftLeft.val!=rightRight.val) return false;
                } else if (leftLeft==null&&rightRight==null) {
                } else return false;

                TreeNode leftRight = left.right;
                TreeNode rightLeft = right.left;
                if (leftRight!=null&&rightLeft!=null){
                    if (leftRight.val!=rightLeft.val) return false;
                } else if (leftRight==null&&rightLeft==null) {
                } else return false;

            }
        }
        return true;

    }
}
