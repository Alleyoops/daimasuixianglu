package com.leetcode.code.lc400_600;

import com.leetcode.util.TreeNode;


public class lc450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        //case1：
        if (root==null) return null;

        if (root.val == key) {
            //case2：
            if (root.left==null&&root.right==null) return null;
            //case3：
            else if (root.right==null) return root.left;
            //case4：
            else if (root.left == null) return root.right;
            //case5：
            else {
                //将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，
                //返回删除节点右孩子为新的根节点。
                findDeepChild(root.right).left = root.left;
                return root.right;
            }
        }
        TreeNode node1 = deleteNode(root.left,key);
        TreeNode node2 = deleteNode(root.right,key);
        root.left = node1;
        root.right = node2;
        return root;

    }
    private TreeNode findDeepChild(TreeNode root){
        if (root==null) return null;
        if (root.left==null) return root;
        return findDeepChild(root.left);
    }
}
