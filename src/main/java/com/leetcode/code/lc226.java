package com.leetcode.code;

import com.leetcode.util.TreeNode;

public class lc226 {
    public TreeNode invertTree(TreeNode root) {
        if (root==null)return null;
        reverse(root);
        return root;
    }
    public void reverse(TreeNode root){
        if (root==null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverse(root.right);
        reverse(root.left);
    }
}
