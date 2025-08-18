package com.leetcode.code.lc200_400;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class lc222 {
    public int countNodes(TreeNode root) {
        //递归遍历
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int countNodes2(TreeNode root) {
        //迭代遍历
        if (root == null) return 0;
        int num = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                    num++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    num++;
                }
                size--;
            }
        }
        return num;
    }

    public int countNodes3(TreeNode root) {
        //利用完全二叉树的特点
        //在完全二叉树中，如果递归向左遍历的深度等于递归向右遍历的深度，那说明就是满二叉树
        //分别递归左孩子，和右孩子，递归到某一深度一定会有左孩子或者右孩子为满二叉树
        // 满二叉树的结点数为：2^depth - 1
        if (root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while (left != null) {
            //左子树深度
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            //右子树深度
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (2<<leftDepth)-1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
