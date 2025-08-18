package com.leetcode.code.lc600above;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class lc617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == null ? root2 : root1;
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        //队列迭代
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            node1.val = node1.val + node2.val;
            if (node1.left!=null&&node2.left!=null){
                queue.offer(node1.left);
                queue.offer(node2.left);
            }
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            // 若node1的左节点为空，直接赋值
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            // 若node1的右节点为空，直接赋值
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
