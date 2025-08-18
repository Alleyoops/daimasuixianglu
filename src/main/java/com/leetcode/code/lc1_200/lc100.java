package com.leetcode.code.lc1_200;

import com.leetcode.util.TreeNode;

public class lc100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null) return true;
        if (p==null||q==null) return false;
        if (p.val!=q.val) return false;
        boolean t1 = isSameTree(p.left,q.left);
        boolean t2 = isSameTree(p.right,q.right);
        return t2&&t1;
    }
}
