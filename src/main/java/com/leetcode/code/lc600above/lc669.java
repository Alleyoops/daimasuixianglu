package com.leetcode.code.lc600above;

import com.leetcode.util.TreeNode;

public class lc669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root==null) return null;

        if (low > root.val){
            //仅要右子树（包涵原root节点）
            return trimBST(root.right,low,high);
        }
        else if (high< root.val){
            //仅要左子树（包含原root节点）
            return trimBST(root.left,low,high);
        } else {
            //root.val在区间内
            TreeNode node1 = trimBST(root.left,low,high);
            TreeNode node2 = trimBST(root.right,low,high);
            root.left = node1;
            root.right = node2;
            return root;
        }
    }
}
