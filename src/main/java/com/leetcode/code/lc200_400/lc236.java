package com.leetcode.code.lc200_400;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
中等常考题：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class lc236 {
    boolean flag = false;
    TreeNode node = new TreeNode();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //后序遍历：左右中
        postOrder(root,p,q);
        return node;
    }
    private void postOrder(TreeNode root, TreeNode p, TreeNode q){
        if (flag) return;
        if (root==null) return;
        //左
        postOrder(root.left,p,q);
        //在递归左子树后，立即检查 flag 是否为 true，如果为 true，直接返回，不再递归右子树。
        if (flag) return;

        //右
        postOrder(root.right,p,q);
        //在递归右子树后，再次检查 flag 是否为 true，如果为 true，直接返回，不处理当前节点。
        if (flag) return;

        //中
        flag = isCommonAncestor(root,p,q);
        if (flag) {
            node = root;
        }
    }

    private boolean isCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root==null) return false;
        boolean t1 = false;
        boolean t2 = false;
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.val==q.val) t1 = true;
            else if (node.val == p.val) t2 = true;
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
        }
        return t1&&t2;
    }
}
