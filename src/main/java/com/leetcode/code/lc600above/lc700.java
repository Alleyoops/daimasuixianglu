package com.leetcode.code.lc600above;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class lc700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) return null;
        if (root.val == val) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left!=null){
                if (node.left.val==val) return node.left;
                else queue.offer(node.left);
            }
            if (node.right!=null){
                if (node.right.val==val) return node.right;
                else queue.offer(node.right);
            }
        }
        return null;
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        //迭代，利用二叉搜索树的有序的特点，进行深度遍历
        while (root!=null){
            if (val<root.val) root = root.left;
            else if (val>root.val) root = root.right;
            else return root;
        }
        return null;
    }

}
