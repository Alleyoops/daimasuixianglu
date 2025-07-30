package com.leetcode.code;

import com.leetcode.util.TreeNode;

public class lc110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftHeight = getHeight(left);
        int rightHeight = getHeight(right);
        if (leftHeight==-1||rightHeight==-1) return false;
        else return Math.abs(leftHeight-rightHeight)<=1;
    }
    public int getHeight(TreeNode node){
        if (node==null) return 0;
        if (!isBalanced(node)) return -1;
        return Math.max(getHeight(node.left),getHeight(node.right))+1;
    }
    public boolean isBalanced2(TreeNode root) {
        return getHeight2(root) != -1;
    }

    private int getHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight2(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight2(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
