package com.leetcode.code.lc400_600;

import com.leetcode.util.TreeNode;

public class lc572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //遍历每个节点
        return preOrder(root,subRoot);
    }
    public boolean preOrder(TreeNode root,TreeNode sub){
        if (root==null&&sub==null) return true;
        if (root!=null&&sub==null) return true;
        if (root == null) return false;
        if (isSameTree(root,sub)) return true;
        return preOrder(root.left,sub)||preOrder(root.right,sub);
    }
    public boolean isSameTree(TreeNode p,TreeNode q){
        if (p==null&&q==null) return true;
        if (p==null||q==null) return false;
        if (p.val!=q.val) return false;
        boolean t1 = isSameTree(p.left,q.left);
        boolean t2 = isSameTree(p.right,q.right);
        return t2&&t1;
    }
}
