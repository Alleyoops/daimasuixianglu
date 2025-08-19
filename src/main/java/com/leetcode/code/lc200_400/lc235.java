package com.leetcode.code.lc200_400;

import com.leetcode.util.TreeNode;

/*
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 */
public class lc235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //参照lc236，不利用二叉搜索树的性质
        //如果 root == q，或者 root == p，说明找到 q p ，则将其返回，这个返回值，后面在中节点的处理过程中会用到
        //找p和q
        if (root == null || root == q || root == p) return root;
        //再从根节点自底向上遍历，即后序遍历-左右中
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left == null && right != null) return right;
        else return left;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //利用二叉搜索树的性质
        if (root == null || root == q || root == p) return root;
        TreeNode Tree;

        if (p.val< root.val) Tree = lowestCommonAncestor2(root.left, p, q);
        else Tree = lowestCommonAncestor2(root.right, p, q);


        if ((p.val< root.val&& root.val< q.val)||p.val> root.val&& root.val> q.val) return root;
        else return Tree;
    }
}
