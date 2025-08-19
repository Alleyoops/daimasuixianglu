package com.leetcode.code.lc400_600;

import com.leetcode.util.TreeNode;

public class lc538 {
    int val = 0;
    public TreeNode convertBST(TreeNode root) {
        //反向中序遍历，即右-中-左
        inOrderInverse(root);
        return root;
    }
    private void inOrderInverse(TreeNode root){
        if (root==null) return ;
        //右
        inOrderInverse(root.right);
        //中
        val+=root.val;
        root.val = val;
        //左
        inOrderInverse(root.left);
    }
}
