package com.leetcode.code.lc1_200;

import com.leetcode.util.TreeNode;

import java.util.*;

public class lc101 {
    //要比较的是根节点的两个子树是否是相互翻转的，进而判断这个树是不是对称树，
    // 所以要比较的是两个树、所以要比较的是两个树、所以要比较的是两个树
    public boolean isSymmetric(TreeNode root) {
        //递归
        //DFS。左右中遍历
        //比较根节点的左子树和右子树是否镜像对称
        if (root == null) return true;
        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;
        return compareLAndR(leftTree, rightTree);

    }

    //比较外侧：左子树的左节点VS右子树的右节点
    //比较内侧：左子树的右节点VS右子树的左节点
    public boolean compareLAndR(TreeNode left, TreeNode right) {

        boolean out, in;
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } else {
            out = compareLAndR(left.left, right.right);
            in = compareLAndR(left.right, right.left);
            return in && out;
        }
    }

    //迭代法，层序遍历
    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }
//            if (leftNode == null && rightNode != null) {
//                return false;
//            }
//            if (leftNode != null && rightNode == null) {
//                return false;
//            }
//            if (leftNode.val != rightNode.val) {
//                return false;
//            }
            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }
}
