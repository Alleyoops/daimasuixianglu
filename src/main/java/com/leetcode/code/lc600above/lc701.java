package com.leetcode.code.lc600above;

import com.leetcode.util.TreeNode;

public class lc701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root==null) return node;

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (root.val>val) {
            root.left = insertIntoBST(left,val);
        }else root.right = insertIntoBST(right,val);
        return root;
    }
}
